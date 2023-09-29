package org.perryCode.peringbackend.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@Column(name = "id")
	private Long postId;
	@Column(name = "publication_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP" )
	private Timestamp publicationdate;
	private String title;
	private String content;
	private int likes;
	
	@ManyToOne(fetch = FetchType.EAGER) // FetchType.EAGER 
	@JoinColumn(name = "fk_users_id", referencedColumnName = "id")
	@JsonIgnoreProperties("posts")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_hashtag_id", referencedColumnName = "id")
	private Hashtag hashtag;
	
	@OneToMany(mappedBy = "post")
	@JsonIgnore
	private List<Comment> comments = new ArrayList<>();
	
}
