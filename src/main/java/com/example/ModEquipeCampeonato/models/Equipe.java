package com.example.ModEquipeCampeonato.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "equipes")
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long idEquipe;

	private String nomeEquipe;
	private String tag;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Jogador> listJogadores;

	public Equipe(long idEquipe, String nomeEquipe, String tag, List<Jogador> listJogadores) {
		super();
		this.idEquipe = idEquipe;
		this.nomeEquipe = nomeEquipe;
		this.tag = tag;
		this.listJogadores = listJogadores;
	}

	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(long idEquipe) {
		this.idEquipe = idEquipe;
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

	public List<Jogador> getListJogadores() {
		return listJogadores;
	}

	public void setListJogadores(List<Jogador> listJogadores) {
		this.listJogadores = listJogadores;
	}
}
