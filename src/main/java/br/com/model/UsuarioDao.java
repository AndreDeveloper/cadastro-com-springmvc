package br.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao {
	private Connection con;
	
	@Autowired
	public UsuarioDao(DataSource ds) {
		try {
			this.con = ds.getConnection();
		} catch (SQLException e) {			
			throw new RuntimeException(e); 
		}
	}

	public void insert(Usuario usuario) {
		try {

			String query = "INSERT INTO `usuario` " + 
			"(`nome`,"+
			" `login`, " +
			"`senha`) " +
			"VALUES (?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());			

			stmt.executeUpdate();

			ResultSet r = stmt.getGeneratedKeys();
			r.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int update(Usuario usuario) {
		int affectedRows = 0;
		try {

			String query = 
					"UPDATE"
					+ " `usuario`"
					+ " SET"
					+ " `nome`=?," 
					+ " `login`=?,"
					+ " `senha`=?,"
					+ " WHERE  `id`=?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getLogin());
			stmt.setString(4, usuario.getSenha());
			stmt.setInt(5, usuario.getId());

			affectedRows = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	public int delete(Usuario usuario) {
		int affectedRows = 0;
		try {

			String query = "DELETE FROM usuario WHERE id = ?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, usuario.getId());

			affectedRows = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	public Usuario selectById(long id) {
		Usuario usuario = new Usuario();
		try {
			String query = "SELECT * FROM usuario WHERE id = ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usuario.setNome(rs.getString("nome"));
				usuario.setNome(rs.getString("login"));
				usuario.setNome(rs.getString("senha"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}
	
	public List<Usuario> selectAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			String query = "SELECT "
					+ " `nome`," 
					+ " `login`," 
					+ " `senha`,"
					+ " FROM usuario;";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setNome(rs.getString("nome"));
				usuario.setNome(rs.getString("login"));
				usuario.setNome(rs.getString("senha"));

				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public String existe(Usuario usuario){
		try {
			String query = "SELECT * FROM usuario WHERE login = ? and senha = ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());

			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				return rs.getString("nome");
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
		

}
