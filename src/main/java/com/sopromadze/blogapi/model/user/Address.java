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
@Document("addresses")
public class Address {

	@Id
	private ObjectId id;

	@CreatedBy
	private ObjectId createdBy;
	@LastModifiedBy
	private ObjectId updatedBy;

	@CreatedDate
	private Instant createdAt;
	@LastModifiedDate
	private Instant updatedAt;

	private String street;

	private String suite;

	private String city;

	private String zipcode;

	private Geo geo;

	private User user;

	public Address(String street, String suite, String city, String zipcode, Geo geo) {
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
		this.geo = geo;
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
