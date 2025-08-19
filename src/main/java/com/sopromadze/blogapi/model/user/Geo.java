package com.sopromadze.blogapi.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Document("geos")
public class Geo {

	@JsonIgnore
	@Id
	private ObjectId id;


	@CreatedDate
	private Instant createdAt;
	@LastModifiedDate
	private Instant updatedAt;

	@CreatedBy
	private ObjectId createdBy;

	@LastModifiedBy
	private ObjectId updatedBy;


	private String lat;

	private String lng;

	private ObjectId address;

	public Geo(String lat, String lng) {
		this.lat = lat;
		this.lng = lng;
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
