package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Etudiant;
import com.inti.repository.IEtudiantRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("etudiant")
@Slf4j
public class EtudiantController {
	
	@Autowired
	IEtudiantRepository etudiantRepository;	
	
	@GetMapping("Etudiants")
	public List<Etudiant> getEtudiants()
	{
		log.info("Liste de tous les Etudiants");
		return etudiantRepository.findAll();
	}
	
	@PostMapping("save")
	public boolean saveEtudiant(@RequestBody Etudiant Etudiant)
	{
		if(Etudiant != null)
		{
			log.info("L'objet Etudiant " + Etudiant + " a pu etre enregistré en BDD.");
			etudiantRepository.save(Etudiant);
			return true;
		}
		log.error("L'objet Etudiant " + Etudiant + " n'a pas pu etre enregistré en BDD !");
		return false;
	}
	
	@DeleteMapping("delete/{id}")
	public boolean deleteEtudiant(@PathVariable int id)
	{
		if(id > 0)
		{
			log.info("Delete de l'objet Etudiant, id : " + id);
			etudiantRepository.deleteById(id);
			return true;
		}
		
		log.error("L'objet Etudiant, id : " + id + " n'a pas pu être supprimé de la BDD !");
		return false;
	}
	
	@GetMapping("Etudiant/{id}")
	public Etudiant getEtudiant(@PathVariable int id)
	{
		try {
			log.info("Etudiant, id : " + id + " récupéré");
			return etudiantRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("L'id : " + id + " n'existe pas en BDD !");
		}
		
		return null;
	}
	
	@PutMapping("update/{id}")
	public Etudiant updateEtudiant(@RequestBody Etudiant nouveauEtudiant, @PathVariable int id)
	{
		return etudiantRepository.findById(id)
				.map(Etudiant -> {
					Etudiant.setNom(nouveauEtudiant.getNom());
					Etudiant.setPrenom(nouveauEtudiant.getPrenom());
					Etudiant.setEmail(nouveauEtudiant.getEmail());
					Etudiant.setTelephone(nouveauEtudiant.getTelephone());
					Etudiant.setAnneeEtude(nouveauEtudiant.getAnneeEtude());
					return etudiantRepository.save(Etudiant);
				})
				.orElseGet(() -> {
					return etudiantRepository.save(nouveauEtudiant);
				});		
	}

}
