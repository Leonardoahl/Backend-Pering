package org.perryCode.peringbackend.entity;


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
@Table(name="users_has_soft_skills")
public class UserHasSoftSkill {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "has_soft_skills_id")
	    private Long hasSoftSkillsId;

	    @Column(name = "fk_users_id")
	    private Long userId;

	    @Column(name = "fk_soft_skills_id")
	    private Long softSkillsId;

	
}


