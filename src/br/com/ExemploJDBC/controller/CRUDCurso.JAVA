package br.com.ExemploJDBC.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.ExemploJDBC.model.Curso;

public class CRUDCurso<T> extends AbstractCRUD<T> {
	
	@Override
	public boolean create(T o) throws SQLException {
		Curso Curso = (Curso) o;
		String query = 
				"INSERT INTO Curso (title, id_department, credit) "
				+ "VALUES (?, ?, ?)";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, Curso.getTitle());
		stmt.setInt(2, Curso.getId_department());
		stmt.setFloat(3, Curso.getCredit());
		int rows = stmt.executeUpdate();
		if(rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM Curso WHERE id_Curso = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		int rows = stmt.executeUpdate();
		return rows > 0;
	}

	@Override
	public boolean update(T o) throws SQLException {
		Curso Curso = (Curso) o;
		String query = "UPDATE Curso "
				+ "SET title = ?,  id_department = ?, credit = ? "
				+ "WHERE id_Curso = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, Curso.getTitle());
		stmt.setInt(2, Curso.getId_department());
		stmt.setFloat(3, Curso.getCredit());
		stmt.setInt(4, Curso.getId_Curso());
		int rows = stmt.executeUpdate();
		return rows > 0;
		
	}

	@Override
	public T getById(int id) throws SQLException {
		
		String query = "SELECT * FROM Curso WHERE id_Curso = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		result.next();
		Curso Curso = new Curso();
		Curso.setId_Curso(result.getInt(1));
		Curso.setTitle(result.getString(2));
		Curso.setId_department(result.getInt(3));
		Curso.setCredit(result.getFloat(4));
		
		return (T) Curso;
	}

	@Override
	public ArrayList<T> listAll() throws SQLException {
		String query = "SELECT * FROM Curso";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		ResultSet result = stmt.executeQuery();
		ArrayList<Curso> Cursos = new ArrayList<Curso>();
		while(result.next()) {
			Curso Curso = new Curso();
			Curso.setId_Curso(result.getInt(1));
			Curso.setTitle(result.getString(2));
			Curso.setId_department(result.getInt(3));
			Curso.setCredit(result.getFloat(4));
			Cursos.add(Curso);
		}
		return (ArrayList<T>) Cursos;
	}

}