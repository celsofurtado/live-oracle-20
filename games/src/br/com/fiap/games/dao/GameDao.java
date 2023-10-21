package br.com.fiap.games.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.games.model.Game;

public class GameDao {
	
	private Connection conexao;
	
	public GameDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void gravar(Game game) {

		String sql = "INSERT INTO tbl_game (ID, TITULO, DATA_LANCAMENTO, FINALIZADO, ID_STUDIO) "
				+ "VALUES (sq_game.nextval, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, game.getTitulo());
			
			Date data = Date.valueOf(game.getDataLancamento());
			ps.setDate(2, data);
			
			int finalizado = game.isFinalizado() ? 1 : 0;
			ps.setInt(3, finalizado);
			
			ps.setInt(4, game.getStudio().getId());
			
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Game cadastrado com sucesso!!!");
			
		} catch (SQLException e) {
			System.out.println("Ops!!!");
			e.printStackTrace();
		}
		
		
	}

	public void excluir(Game game) {

	}

	public void atualizar(Game game) {

	}

	public List<Game> listarTodos() {
		
		String sql = "SELECT * FROM TBL_GAME ORDER BY id";
		List<Game> games = null;
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
	
			ResultSet rs = ps.executeQuery();
		;
			
			games = new ArrayList();
			
			while (rs.next()) {
				Game g = new Game();
				g.setId(rs.getInt("id"));
				g.setTitulo(rs.getString("titulo"));
				games.add(g);
			}
			
			ps.close();
			conexao.close();
			
			System.out.println("Game cadastrado com sucesso!!!");
			
		} catch (SQLException e) {
			System.out.println("Ops!!!");
			e.printStackTrace();
		}
		
		return games;

	}
	
	public void buscarGamePorId(int id) {
		
		String sql = "SELECT * FROM TBL_GAME WHERE id = ?";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			Game g = new Game();
			
			if (rs.next()) {
				g.setId(rs.getInt("id"));
				g.setTitulo(rs.getString("titulo"));
			}
			
			System.out.println(g);
			
			ps.close();
			conexao.close();
			
			System.out.println("Game cadastrado com sucesso!!!");
			
		} catch (SQLException e) {
			System.out.println("Ops!!!");
			e.printStackTrace();
		}
		
	}
	

}
