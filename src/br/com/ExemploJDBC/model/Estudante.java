package br.com.ExemploJDBC.model;

public class Estudante {
	
	private int id_estudante;
	private String name_estudante;
	private int id_department;
	
	public int getId_estudante() {
		return id_estudante;
	}
	public void setId_estudante(int id_estudante) {
		this.id_estudante = id_estudante;
	}
	public String getName_estudante() {
		return name_estudante;
	}
	public void setName_estudante(String name_estudante) {
		this.name_estudante = name_estudante;
	}
	public int getId_department() {
		return id_department;
	}
	public void setId_department(int id_department) {
		this.id_department = id_department;
	}

	
}