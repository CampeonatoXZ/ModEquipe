package com.example.ModEquipeCampeonato.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


@Entity
@Table(name = "equipes")

public class Equipe   {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nomeEquipe;
	private String tag;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinTable(name = "equipe_jogador", joinColumns = @JoinColumn(name = "equipe_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "jogador_id", referencedColumnName = "id"))
    private List<Jogador> listjogadores = new ArrayList<>();

	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipe(long id, String nomeEquipe, String tag, List<Jogador> listJogadores) {
		super();
		this.id = id;
		this.nomeEquipe = nomeEquipe;
		this.tag = tag;
		this.listjogadores = listJogadores;
	}

	public Equipe(String nomeEquipe, String tag, List<Jogador> listJogadores) {
		super();
		this.nomeEquipe = nomeEquipe;
		this.tag = tag;
		this.listjogadores = listJogadores;
	}
	
	public Equipe(String nomeEquipe, String tag) {
		super();
		
		this.nomeEquipe = nomeEquipe;
		this.tag = tag;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeEquipe() {
		return nomeEquipe;
	}

	public void setNomeEquipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	/*public List<Jogador> getListJogadores(){
		return listjogadores;
	}*/
	
	public List<Long> getListJogadores() {
		List<Long> nomes = new ArrayList<Long>();
		
	for(Jogador jogador : listjogadores) {
		nomes.add((jogador.getId()));
	}		
		return nomes;
	}

	public void setListJogadores(List<Jogador> listJogadores) {
		this.listjogadores = listJogadores;
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", nomeEquipe=" + nomeEquipe + ", tag=" + tag + ", listjogadores=" + listjogadores
				+ "]";
	}
	
	

	
}
