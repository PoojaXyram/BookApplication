package com.enterprise.bookapplication.dto;



import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

public class CategoryDto {
    private Integer id;

    @Size(max = 25, message = "Title must be of maximum 25 characters")
    private String title;

    @NotEmpty
    private Timestamp createdAt;

    @NotEmpty
    @Max(value = 50,message = "Exceeded length")
    private String description;

    @Pattern(regexp = "^[a-z0-9-]+$", message = "slug only in lowercase")
    private String slug;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
