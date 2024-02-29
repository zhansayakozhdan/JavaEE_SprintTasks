package model;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private LocalDateTime createdAt;
    private PostsCategory category;
    private String title;
    private String content;
    public Post(){

    }

    public Post(Long id, LocalDateTime createdAt, PostsCategory category, String title, String content) {
        this.id = id;
        this.createdAt = createdAt;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public Post(String title, String content, PostsCategory category){
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public PostsCategory getCategory() {
        return category;
    }

    public void setCategory(PostsCategory category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
