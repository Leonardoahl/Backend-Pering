package org.perryCode.peringbackend.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "publication_date")
	private Date publicationdate;
	private String title;
	private String content;
	private int likes;
	@Column(name = "fk_users_id")
	private Long fkusersid;
	@Column(name = "fk_hashtag_id")
	private Long fkhashtagid;
}
