package com.sopromadze.blogapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
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
@Document("photos")
public class Photo {
	@Id
	private ObjectId id;

	@NotBlank
	private String title;

	@CreatedDate
	private Instant createdAt;
	@LastModifiedDate
	private Instant updatedAt;

	@CreatedBy
	private ObjectId createdBy;

	@LastModifiedBy
	private ObjectId updatedBy;

	@NotBlank
	private String url;

	@NotBlank
	private String thumbnailUrl;

	private ObjectId album;

	public Photo(@NotBlank String title, @NotBlank String url, @NotBlank String thumbnailUrl, ObjectId album) {
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
		this.album = album;
	}

	@JsonIgnore
	public ObjectId getAlbum() {
		return album;
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

