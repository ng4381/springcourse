package com.example.springcourse.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Data
public class Comment extends Auditable{

    @Id
    @GeneratedValue
    private Long id;
    private String body;

    // link
    @ManyToOne
    private Link link;
}
