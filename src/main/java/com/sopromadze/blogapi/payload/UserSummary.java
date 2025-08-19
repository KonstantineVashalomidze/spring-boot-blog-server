package com.sopromadze.blogapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSummary {
	private String id;
	private String username;
	private String firstName;
	private String lastName;
}
