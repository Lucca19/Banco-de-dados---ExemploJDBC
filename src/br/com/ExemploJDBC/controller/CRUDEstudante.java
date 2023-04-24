package br.com.ExemploJDBC.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ExemploJDBC.model.Estudante;

public class CRUDEstudante<T> extends AbstractCRUD<T> {
	
	@Override
	public boolean create(T o) throws SQLException {
		Estudante estudante = (Estudante) o;
		String query = 
				"INSERT INTO estudante (name_estudante, id_department) "
				+ "VALUES (?, ?)";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, estudante.getName_estudante());
		stmt.setInt(2, estudante.getId_department());
		int rows = stmt.executeUpdate();
		if(rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM estudante WHERE id_estudante = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		int rows = stmt.executeUpdate();
		return rows > 0;
	}

	@Override
	public boolean update(T o) throws SQLException {
		Estudante estudante = (Estudante) o;
		String query = "UPDATE estudante "
				+ "SET name_estudante = ?, id_department = ? "
				+ "WHERE id_estudante = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setString(1, estudante.getName_estudante());
		stmt.setInt(2, estudante.getId_department());
		stmt.setInt(3, estudante.getId_estudante());
		int rows = stmt.executeUpdate();
		return rows > 0;
		
	}

	@Override
	public T getById(int id) throws SQLException {
		
		String query = "SELECT * FROM estudante WHERE id_estudante = ?";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		result.next();
		Estudante estudante = new Estudante();
		estudante.setId_estudante(result.getInt(1));
		estudante.setName_estudante(result.getString(2));
		estudante.setId_department(result.getInt(3));
		
		return (T) estudante;
	}

	@Override
	public ArrayList<T> listAll() throws SQLException {
		String query = "SELECT * FROM estudante";
		PreparedStatement stmt = super.connection.prepareStatement(query);
		ResultSet result = stmt.executeQuery();
		ArrayList<Estudante> estudantes = new ArrayList<Estudante>();
		while(result.next()) {
			Estudante estudante = new Estudante();
			estudante.setId_estudante(result.getInt(1));
			estudante.setName_estudante(result.getString(2));
			estudante.setId_department(result.getInt(3));
			estudantes.add(estudante);
		}
		return (ArrayList<T>) estudantes;
	}
}