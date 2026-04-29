package com.todo.backend.model;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private boolean done;

    public Long getId() { return id; }
    public String getText() { return text; }
    public boolean isDone() { return done; }

    public void setId(Long id) { this.id = id; }
    public void setText(String text) { this.text = text; }
    public void setDone(boolean done) { this.done = done; }
}