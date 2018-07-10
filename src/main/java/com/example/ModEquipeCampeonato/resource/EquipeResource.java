package com.example.ModEquipeCampeonato.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ModEquipeCampeonato.models.Equipe;
import com.example.ModEquipeCampeonato.repository.EquipeRepository;



@RestController
@RequestMapping("/equipe")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipeResource {

	@Autowired
	private EquipeRepository repository;

	@PostMapping()
	public Equipe postEquipe(@RequestBody @Valid Equipe equipe) {
		return repository.save(equipe);
	}

	@GetMapping(produces = "application/json;charset=UTF-8")
	public @ResponseBody Iterable<Equipe> listaEquipes() {
		Iterable<Equipe> listaEquipes = repository.findAll();
		return listaEquipes;
	}
	
	@GetMapping("/{id}")
	public Equipe getEquipe(@PathVariable Long id){
        return repository.findOne(id);
    }

	@DeleteMapping()
	public Equipe deletaEquipe(@RequestBody Equipe equipe) {
		repository.delete(equipe);
		return equipe;
	}
}
