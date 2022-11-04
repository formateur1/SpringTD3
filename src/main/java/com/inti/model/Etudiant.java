package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "etudiant_td3")
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Etudiant {
	
	@Id
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private int anneeEtude;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Professeur_Etudiant",
				joinColumns = @JoinColumn(name = "idEtudiant"),
				inverseJoinColumns = @JoinColumn(name = "idProfesseur"))
	private List<Professeur> listeProfesseur;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEcole")
	private Ecole ecole;

}
