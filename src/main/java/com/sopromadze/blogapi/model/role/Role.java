package com.sopromadze.blogapi.model.role;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("roles")
public class Role {
	@Id
	private ObjectId id;
	private RoleName name;

	public Role(RoleName name) {
		this.name = name;
	}
}
