package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Professeur;
import com.inti.repository.IProfesseurRepository;

@RestController
@RequestMapping("prof")
public class ProfController {

	@Autowired
	IProfesseurRepository ipr;
	
	@GetMapping("profs")
	public List<Professeur> listeProfs()
	{
		return ipr.findAll();
	}
}
