package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ecole_td3")
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Ecole {

	@Id
	private int id;
	private String nom;
	private String adresse;
	private int cp;
	private String ville;
	
	@ManyToMany
	@JoinTable(name = "Ecole_Professeur",
				joinColumns = @JoinColumn(name = "idEcole"),
				inverseJoinColumns = @JoinColumn(name = "idProfesseur"))
	private List<Professeur> listeProfesseur;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ecole")
	private List<Etudiant> listeEtudiant;

	public Ecole(int id, String nom, String adresse, int cp, String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}
	
	
}
