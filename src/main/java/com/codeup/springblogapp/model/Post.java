package com.codeup.springblogapp.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 75)
    private String title;

    @Column(length = 5000)
    private String description;

    @Column
    private String category;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", updatable = false)
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;


    public Post() { }

    public Post(long id, String title, String category, String description, Date createDate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.createDate = createDate;
    }

    public Post(String title, String category, String description, Date createDate) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.createDate = createDate;
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

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Date getCreateDate() { return createDate; }
    public void setCreateDate(Date createDate) { this.createDate = createDate; }

    public Date getModifyDate() { return modifyDate; }
    public void setModifyDate(Date modifyDate) { this.modifyDate = modifyDate; }
}
