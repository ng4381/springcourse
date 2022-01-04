package com.example.springcourse.service;

import com.example.springcourse.domain.User;
import com.example.springcourse.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;
    private final MailService mailService;

    public UserService(UserRepository userRepository, RoleService roleService, MailService mailService) {
        encoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.mailService = mailService;
    }

    public User register(User user) {


        String secret = "{bcrypt}" + encoder.encode(user.getPassword());
        user.setPassword(secret);

        user.addRole(roleService.findByName("ROLE_USER"));

        user.setActivationCode(UUID.randomUUID().toString());

        save(user);

        sendActivationEmail(user);


        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }


    @Transactional
    public void saveUsers(User... users) {
        for (User user : users) {
            logger.info("Saving User: " + user.getEmail());
            userRepository.save(user);
        }
    }

    public void sendActivationEmail(User user) {
        mailService.sendActivationEmail(user);
    }

    public void sendWelcomeEmail(User user) {
        mailService.sendWelcomeEmail(user);
    }

    public Optional<User> findByEmailAndActivationCode(String email, String activationCode){
        return userRepository.findByEmailAndActivationCode(email, activationCode);
    }
}
