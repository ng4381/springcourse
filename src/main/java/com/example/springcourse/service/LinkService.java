package com.example.springcourse.service;

import com.example.springcourse.domain.Link;
import com.example.springcourse.repository.CommentRepository;
import com.example.springcourse.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {

    private LinkRepository linkRepository;
    private CommentRepository commentRepository;

    public LinkService(LinkRepository linkRepository, CommentRepository commentRepository) {
        this.linkRepository = linkRepository;
        this.commentRepository = commentRepository;
    }

    public List<Link> findAll() {
        return linkRepository.findAll();
    }

    public Optional<Link> findById(Long id) {
        return linkRepository.findById(id);
    }

    public Link save(Link link) {
        return linkRepository.save(link);
    }
}
