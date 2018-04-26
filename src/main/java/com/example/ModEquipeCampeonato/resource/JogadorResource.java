package com.example.ModEquipeCampeonato.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ModEquipeCampeonato.models.Jogador;
import com.example.ModEquipeCampeonato.repository.JogadorRepository;

@RestController
@RequestMapping("/jogador")
public class JogadorResource {
	
	@Autowired
	private JogadorRepository repository;
	
	@PostMapping()
	public Jogador postJogador(@RequestBody @Valid Jogador jogador) {
		return repository.save(jogador);
	}
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Jogador> listaJogadores() {
		Iterable<Jogador> listaJogadores = repository.findAll();
		return listaJogadores;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public void updateJogador(@RequestBody Jogador jogador, @PathVariable("id") long id) {
		if (id != jogador.getId()) {
			repository.delete(jogador);
		}
		repository.save(jogador);
	}
	
	
	@DeleteMapping()
	public Jogador deletaJogadores(@RequestBody Jogador jogador) {
		repository.delete(jogador);
		return jogador;
	}
}
