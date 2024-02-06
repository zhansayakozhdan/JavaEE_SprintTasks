package models;

public class Post {
    private Long id;
    private String title;
    private String content;
    private String author;
    private CategoryType category;

    public enum CategoryType {
        SPORT, CINEMA, CULTURE
    }

    public Post() {

    }

    public Post(Long id, String title, String content, String author, CategoryType category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }
}
