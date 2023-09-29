package org.perryCode.peringbackend.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String content;
	private int likes;
	@Column(name = "publication_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP" )
	private Timestamp commentDate;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_posts_id" )
	//@JsonIgnoreProperties("comments") // Evita la recursión infinita
	private Post post;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_comment_users_id")
	private User user;
	
}

