package com.ti2cc;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		
		//Inserir um elemento na tabela
		Filme filmes = new Filme(16112001, "Harry Potter", "pablo", 152, "Aventura e fantasia");
		if(dao.inserirFilme(filmes) == true) {
			System.out.println("Inserção com sucesso -> " + filmes.toString());
		}
		
		//Mostrar filmes com mais de 2 horas de duração		
		System.out.println("==== Mostrar filmes com mais de 2 horas de duração	 === ");
		Filme[] filmes = dao.getFilmeDuracao());
		for(int i = 0; i < filmes.length; i++) {
			System.out.println(filmes[i].toString());
		}

		
		//Excluir filme
		dao.excluirFilme(filme.getNome());
		
		//Mostrar filmes
		filmes = dao.getFilme();
		System.out.println("==== Mostrar Filmes === ");		
		for(int i = 0; i < filmes.length; i++) {
			System.out.println(filmes[i].toString());
		}
		
		dao.close();
	}
}