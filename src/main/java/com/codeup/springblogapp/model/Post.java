package com.codeup.springblogapp.model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, length = 75)
    private String title;

    @Column (length = 5000)
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User owner;



    public Post() {}

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
