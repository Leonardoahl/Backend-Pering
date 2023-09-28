package org.perryCode.peringbackend.entity;




import java.security.Principal;
import java.util.Date;

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
	private Date birthday;
	private Date registerDate;

	
}
