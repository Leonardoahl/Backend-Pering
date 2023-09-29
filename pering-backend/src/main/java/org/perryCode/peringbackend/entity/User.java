package org.perryCode.peringbackend.entity;



import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class User{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String profilepic;
	private String description;
	private Timestamp registerDate;
		

	
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties("user")
	private List<Post> posts = new ArrayList<>();

}
