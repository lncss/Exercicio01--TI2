package com.ti2cc;

import java.sql.*;

public class DAO {
	private Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "teste";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ti2cc1";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirFilme(Filme filme) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO usuario (codigo, login, senha, sexo) "
					       + "VALUES ("+filme.getNome()+ ", '" + filme.getLancamento() + "', '"  
					       + filme.getDuracao() + "', '" + filme.getDiretor() + "', '"+ filme.getGenero() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarUsuario(Filme filme) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE filme SET genero = '" + filme.getGenero() + "', lancamento = '"  
				       + filme.getLancamento() + "', Diretor = '" + filme.getDiretor() + "', Duracao'" + filme.getDuracao() + "'" 
					   + " WHERE nome = " + filme.getNome();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirFilme(String nome) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM filme WHERE nome = " + nome);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Filme[] getFilme() {
		Filme[] filme = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario");		
	         if(rs.next()){
	             rs.last();
	             filme = new Filme[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                filme[i] = new Filme(rs.getString("nome"), rs.getString("diretor"), rs.getInt("duracao"),
	                		                  rs.getString("genero"), rs.getInt("lancamento").intAt(0));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return filme;
	}

	
	public Filme[] getFilmeDuracao() {
		Filme[] filmes = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM filme WHERE filme.usuario LIKE 120 ");		
	         if(rs.next()){
	             rs.last();
	             filmes = new Filme[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
		                filmes[i] = new Filme(rs.getString("nome"), rs.getString("diretor"), rs.getInt("duracao"),
      		                                     rs.getString("genero"), rs.getInt("lancamento").intAt(0));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return filmes;
	}
}