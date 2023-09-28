package org.perryCode.peringbackend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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
@Table(name="users_has_soft_skills")
public class UserHasSoftSkill {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "has_soft_skills_id")
	    private Long hasSoftSkillsId;

	  	@ManyToOne
	    @JoinColumn(name = "fk_users_id", nullable = false)
	  	@JsonIgnore
	    private User userId;

	  	@ManyToOne
	    @JoinColumn(name = "fk_soft_skills_id", nullable = false)
	  	//@JsonIgnore
	    private SoftSkill softSkillsId;

	
}


