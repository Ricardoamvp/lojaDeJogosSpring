package com.ramvp.lojaDeJogos.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_jogo")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Jogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String nome;

	private String descricao;

	private Integer anoLancamento;

	@ManyToOne(optional = false)
	@JsonIgnoreProperties("jogos")
	private Categoria categoria;

}