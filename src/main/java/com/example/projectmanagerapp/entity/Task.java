package com.example.projectmanagerapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Date createDate;
    private Date modifyDate;
    @Enumerated(EnumType.STRING)
    private ImplementerType implementerType;

    @OneToOne
    @JoinColumn(name = "author_id")
    private AppUser author;

    private String message;

    @ManyToOne()
    @JoinColumn(name = "project_id")
    private Project project;
}
