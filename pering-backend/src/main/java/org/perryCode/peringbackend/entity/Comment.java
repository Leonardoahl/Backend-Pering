package org.perryCode.peringbackend.entity;

import java.util.Date;

import jakarta.persistence.Entity;
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
	private Date commentDate;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_posts_id" )
	private Post post;
	
	@ManyToOne
	@JoinColumn(name = "fk_users_id" )
	private User user;
	
	
}
