package com.sopromadze.blogapi.payload;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class PhotoResponse {
	private String id;
	private String title;
	private String url;
	private String thumbnailUrl;
	private String albumId;

	public PhotoResponse(String id, String title, String url, String thumbnailUrl, String albumId) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
		this.albumId = albumId;
	}

}
