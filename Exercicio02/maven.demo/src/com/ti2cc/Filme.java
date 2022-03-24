package com.ti2cc;

public class Filme {
	private int lancamento;
	private String nome;
	private String diretor;
	private int duracao;
	private String genero;
	
	public Filme() {
		this.lancamento = 0;
		this.nome = "";
		this.duracao = 0;
		this.diretor = "";
		this.genero = "";
	}
	
	public Filme(int lancamento, String nome, String diretor, int duracao, String genero) {
		this.lancamento = lancamento;
		this.nome = nome;
		this.diretor = diretor;
		this.duracao = duracao;
		this.genero = genero;
	}

	public int getLancamento() {
		return lancamento;
	}

	public void setLancamento(int lancamento) {
		this.lancamento = lancamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public String getGenero() {
		return genero; 
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	

	@Override
	public String toString() {
		return "Filme [lancamento=" + lancamento + ", nome=" + nome + ", diretor=" + diretor + ", duracao=" + duracao + "genero=" + genero + "]";
	}	
}
