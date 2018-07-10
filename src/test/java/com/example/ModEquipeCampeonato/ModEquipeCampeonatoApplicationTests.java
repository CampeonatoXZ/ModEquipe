package com.example.ModEquipeCampeonato;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ModEquipeCampeonato.models.Equipe;
import com.example.ModEquipeCampeonato.models.Jogador;
import com.example.ModEquipeCampeonato.repository.EquipeRepository;
import com.example.ModEquipeCampeonato.repository.JogadorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModEquipeCampeonatoApplicationTests {

	@Autowired
	private JogadorRepository repJogador;
	@Autowired
	private EquipeRepository repEquipe;
	
	@Test
	public void contextLoads() {

		
	}
	
	@Test
	public void CreateJogador() throws JsonProcessingException, ParseException {
		String dataString = "29/07/1984";
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());
		
		
		Jogador jogador = new Jogador("John", "teste@teste.com", "Dres", data);
	    Equipe equipe = new Equipe("book", "lag");
	    
	    jogador.addEquipe(equipe);
	    repJogador.save(jogador);
	    
	}



}
