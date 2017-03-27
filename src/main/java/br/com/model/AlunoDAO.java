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
public class AlunoDAO {
	private Connection con;
	
	@Autowired
	public AlunoDAO(DataSource ds) {
		try {
			this.con = ds.getConnection();
		} catch (SQLException e) {			
			throw new RuntimeException(e); 
		}
	}

	public void insert(Aluno aluno) {
		try {

			String query = "INSERT INTO `aluno` " + 
			"(`matricula`,"+
			" `nome`, " +
			"`rg`, " +
			"`cpf`, " +
			"`data_nascimento`) " + 
			"VALUES (?, ?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getRg());
			stmt.setString(4, aluno.getCpf());			
			stmt.setString(5, aluno.getDataNascimento());
			stmt.executeUpdate();

			ResultSet r = stmt.getGeneratedKeys();
			r.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int update(Aluno aluno) {
		int affectedRows = 0;
		try {

			String query = 
					"UPDATE"
					+ " `aluno`"
					+ " SET"
					+ " `matricula`=?," 
					+ " `nome`=?,"
					+ " `rg`=?,"
					+ " `cpf`=?,"
					+ " `data_nascimento`=?"
					+ " WHERE  `matricula`=?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getRg());
			stmt.setString(4, aluno.getCpf());
			stmt.setString(5, aluno.getDataNascimento());

			stmt.setLong(6, aluno.getMatricula());

			affectedRows = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	public int delete(Aluno aluno) {
		int affectedRows = 0;
		try {

			String query = "DELETE FROM aluno WHERE matricula = ?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, aluno.getMatricula());

			affectedRows = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	public Aluno selectById(long id) {
		Aluno aluno = new Aluno();
		try {
			String query = "SELECT * FROM aluno WHERE matricula = ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				aluno.setMatricula(rs.getLong("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setRg(rs.getString("rg"));
				aluno.setCpf(rs.getString("rg"));
				aluno.setDataNascimento( rs.getString("data_nascimento"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aluno;
	}

	public List<Aluno> selectAll() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			String query = "SELECT "
					+ " `matricula`," 
					+ " `nome`," 
					+ " `rg`,"
					+ " `cpf`," 
					+ " `data_nascimento`" 					
					+ " FROM aluno;";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getLong("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setRg(rs.getString("rg"));
				aluno.setCpf(rs.getString("rg"));
				aluno.setDataNascimento(rs.getString("data_nascimento"));

				alunos.add(aluno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return alunos;
	}


		
}
