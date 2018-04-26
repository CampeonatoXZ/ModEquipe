package com.example.ModEquipeCampeonato.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "jogadores")
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;

	private String nome;
	private String email;
	private Date dt_nascimento;
	private String nickNameJogo;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonBackReference
	private Equipe equipe;

	public Jogador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jogador(long id, String nome, String email, Date dt_nascimento, String nickNameJogo, Equipe equipe) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dt_nascimento = dt_nascimento;
		this.nickNameJogo = nickNameJogo;
		this.equipe = equipe;
	}

	public Jogador(String nome, String email, Date dt_nascimento, String nickNameJogo, Equipe equipe) {
		super();
		this.nome = nome;
		this.email = email;
		this.dt_nascimento = dt_nascimento;
		this.nickNameJogo = nickNameJogo;
		this.equipe = equipe;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public String getNickNameJogo() {
		return nickNameJogo;
	}

	public void setNickNameJogo(String nickNameJogo) {
		this.nickNameJogo = nickNameJogo;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}