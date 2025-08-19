package com.sopromadze.blogapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sopromadze.blogapi.model.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@Document("comments")
public class Comment {
    @Id
    private ObjectId id;

    @NotBlank
    @Size(min = 4, max = 50)
    private String name;

    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    @CreatedBy
    private ObjectId createdBy;

    @LastModifiedBy
    private ObjectId updatedBy;

    @NotBlank
    @Email
    @Size(min = 4, max = 50)
    private String email;

    @NotBlank
    @Size(min = 10)
    private String body;

    private ObjectId post;

    private ObjectId user;

    public Comment(@NotBlank @Size(min = 10) String body) {
        this.body = body;
    }

    @JsonIgnore
    public ObjectId getPost() {
        return post;
    }

    @JsonIgnore
    public ObjectId getUser() {
        return user;
    }

    @JsonIgnore
    public ObjectId getId() {
        return id;
    }


    @JsonIgnore
    public ObjectId getCreatedBy() {
        return createdBy;
    }

    @JsonIgnore
    public void setCreatedBy(ObjectId createdBy) {
        this.createdBy = createdBy;
    }

    @JsonIgnore
    public ObjectId getUpdatedBy() {
        return updatedBy;
    }

    @JsonIgnore
    public void setUpdatedBy(ObjectId updatedBy) {
        this.updatedBy = updatedBy;
    }

    @JsonIgnore
    public Instant getCreatedAt() {
        return createdAt;
    }

    @JsonIgnore
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @JsonIgnore
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @JsonIgnore
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
