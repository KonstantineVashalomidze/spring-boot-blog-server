package com.sopromadze.blogapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@EqualsAndHashCode
@Data
@Document("todos")
public class Todo {
	@Id
	private ObjectId id;

	@NotBlank
	private String title;

	private Boolean completed;

	private ObjectId user;

	@CreatedDate
	private Instant createdAt;
	@LastModifiedDate
	private Instant updatedAt;

	@CreatedBy
	private ObjectId createdBy;

	@LastModifiedBy
	private ObjectId updatedBy;

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
