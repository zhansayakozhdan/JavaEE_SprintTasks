package model;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private String value;
    private LocalDateTime postedAt;
    private User user;
    private Post post;

    public Comment() {

    }

    public Comment(Long id, String value, LocalDateTime postedAt, User user, Post post) {
        this.id = id;
        this.value = value;
        this.postedAt = postedAt;
        this.user = user;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
