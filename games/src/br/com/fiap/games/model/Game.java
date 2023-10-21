package br.com.fiap.games.model;

import java.time.LocalDate;

public class Game {

	private int id;
	private String titulo;
	private LocalDate dataLancamento;
	private boolean finalizado;
	private Studio studio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	@Override
	public String toString() {
		return "Id-> " + id + "\nTitulo-> "+ titulo;
	}
	

}
