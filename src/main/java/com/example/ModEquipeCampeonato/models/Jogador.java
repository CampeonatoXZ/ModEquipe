package com.example.ModEquipeCampeonato.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;



@Entity
@Table(name = "jogadores")

public class Jogador {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nome;
	private String email;
	private Date dt_nascimento;
	private String nickNameJogo;
	
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="listjogadores")
	@JsonIgnore
	private List<Equipe> listequipes = new ArrayList<>();

	public Jogador() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Jogador(long id, String nome, String email, Date dt_nascimento, String nickNameJogo, List<Equipe> equipes) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dt_nascimento = dt_nascimento;
		this.nickNameJogo = nickNameJogo;
		this.listequipes = equipes;
	}
	
	public Jogador(String nome, String email, String nickNameJogo, Date dt_nascimento) {
		super();
		
		this.nome = nome;
		this.email = email;
		this.nickNameJogo = nickNameJogo;
		this.dt_nascimento = dt_nascimento;
		
	}

	
	public Jogador(String nome, String email, Date dt_nascimento, String nickNameJogo, List<Equipe> equipes) {
		super();
		this.nome = nome;
		this.email = email;
		this.dt_nascimento = dt_nascimento;
		this.nickNameJogo = nickNameJogo;
		this.listequipes = equipes;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	/*public List<Equipe> getEquipes() {
		return listequipes;
	}*/
	
	public List<Long> getEquipes() {
		List<Long> nomes = new ArrayList<Long>();
	for(Equipe equipe : listequipes) {
		nomes.add(equipe.getId());
	}		
		return nomes;
	}
	
	public void addEquipe(Equipe equipe) {
		List<Equipe> lista = new ArrayList<Equipe>();
		lista.add(equipe);
		setEquipes(lista);
		
	}

	public void setEquipes(List<Equipe> equipes) {
		this.listequipes = equipes;
	}


	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nome=" + nome + ", email=" + email + ", dt_nascimento=" + dt_nascimento
				+ ", nickNameJogo=" + nickNameJogo + ", listequipes=" + listequipes + "]";
	}
	
	

}