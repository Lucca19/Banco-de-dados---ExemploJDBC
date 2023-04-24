package br.com.ExemploJDBC.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ExemploJDBC.model.Department;
import br.com.ExemploJDBC.model.Curso;
import br.com.ExemploJDBC.model.Estudante;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		AbstractCRUD<Department> department;
		AbstractCRUD<Curso> Curso;
		AbstractCRUD<Estudante> Estudante;
		
		department = new CRUDDepartment<Department>();
		Curso = new CRUDCurso<Curso>();
		Estudante = new CRUDEstudante<Estudante>();
		
		int opcao = 0;
		
		try {
			System.out.println(department.open() + " Deparment open");
			System.out.println(Curso.open() + " Curso open");
			System.out.println(Estudante.open() + " Estudante open");
			
			 while (opcao != 9){
		            System.out.println("");
		            System.out.println("CONSULTA EM BANCO");
		            System.out.println("");
		            System.out.println("1- Tabela Department");
		            System.out.println("2- Tabela Curso");
		            System.out.println("3- Tabela Estudante");
		            System.out.println("9- Fim");
		            opcao = scanner.nextInt();
		            
		            switch (opcao){
		           
	                case 1:
	                	
	                	int numDepartment = 0;
	                    
	                    while(numDepartment != 9) {
	                    
						System.out.println("");
	                    System.out.println("Tabela de Departmentos");
						System.out.println("");
	                    System.out.println("Escolha a operação");
	                    System.out.println("1- Criar Departamento");
	                    System.out.println("2- Deletar Departamento");
	                    System.out.println("3- Atualizar Departamento");
	                    System.out.println("4- Buscar Departamento");
	                    System.out.println("5- Mostrar os departamentos");
	                    System.out.println("9- Voltar");
	                    
	                    numDepartment = scanner.nextInt();
	                   	
	                    switch(numDepartment) {
	                    
	                    case 1:
	                    	System.out.println("Criar Departamento");
	                    	Department dCreate = new Department();
	                    	System.out.println("Nome do Departamento");
	            			dCreate.setNameDepartment(scanner.next());
	            			System.out.println("Nome do Predio");
	            			dCreate.setBuildingDepartment(scanner.next());
	            			System.out.println("Quantidade de Budget");
	            			dCreate.setBudgetDepartment(scanner.nextFloat());
	            			
	            			boolean d_res_create = department.create(dCreate);
	            			System.out.println(d_res_create + " DEPARTAMENTO CRIADO COM SUCESSO");
	            			System.out.println("");
	            			
	            			break;
	            			
	                    case 2:
		                	System.out.println("Deletar Departamento");
		                	System.out.println("Informe o ID do departamento");
		                	
		                	boolean d_res_delete = department.delete(scanner.nextInt());
		                	System.out.println(d_res_delete + " DEPARTAMENTO DELETADO COM SUCESSO");
		                	System.out.println("");
		                	
		                    break;
		                    
	                    case 3:
		                	System.out.println("Atualizar Departamento");
		                	Department dUpdate = new Department();
		                	System.out.println("Informe o ID do departamento");
		        			dUpdate.setIdDepartment(scanner.nextInt());
		        			System.out.println("Atualize o nome do departamento");
		        			dUpdate.setNameDepartment(scanner.next());
		        			System.out.println("Atualize o predio do departamento");
		        			dUpdate.setBuildingDepartment(scanner.next());
		        			System.out.println("Atualize o budget do departamento");
		        			dUpdate.setBudgetDepartment(scanner.nextFloat());
		        			
		        			boolean d_res_update = department.update(dUpdate);
		        			System.out.println(d_res_update + " DEPARTAMENTO ATUALIZADO COM SUCESSO");
		        			System.out.println("");
		        		
		                    break;
		                    
	                    case 4:
							System.out.println("");
		                	System.out.println("Buscar Departamento");
							System.out.println("");
		  		            System.out.println("Informe o ID do departamento");
		  		            Department dSelect = department.getById(scanner.nextInt());
		  		            System.out.println("");
		  		            System.out.println("Nome do departamento: " + dSelect.getNameDepartment());
		  		            System.out.println("Nome do predio: " + dSelect.getBuildingDepartment());
		  		            System.out.println("Quantidade de budget: " + dSelect.getBudgetDepartment());
		  		            System.out.println("");
		                    break;
		                    
	                    case 5:   
		                    ArrayList<Department> departments = department.listAll();
		        			for(Department d : departments) {
		        				System.out.println("");
			  		            System.out.println("ID do Departamento: " + d.getIdDepartment());
			  		            System.out.println("Nome do departamento: " + d.getNameDepartment());
			  		            System.out.println("Nome do predio: " + d.getBuildingDepartment());
			  		            System.out.println("Quantidade de budget: " + d.getBudgetDepartment());
			  		            System.out.println("");
		        			}
		        			
		        			break;
		                    
	                    default:
		                    System.out.println("---ERRO---");  
	                  
	                    }
	                    
					}

	                case 2: 
	                	
	                	int numCurso = 0;
	                    
	                    while(numCurso != 9) {
	                    	System.out.println("");
	                    	System.out.println("Tabela Curso");
							System.out.println("");
		                    System.out.println("Escolha a operação");
		                    System.out.println("1- Criar Curso");
		                    System.out.println("2- Deletar Curso");
		                    System.out.println("3- Atualizar Curso");
		                    System.out.println("4- Buscar Curso");
		                    System.out.println("5- Mostrar todos os cursos");
		                    System.out.println("9- Voltar");
		                   
		                    numCurso= scanner.nextInt();
		                   
		                    switch(numCurso) {
		                    
		                    case 1:
		                    	System.out.println("Criar Curso");
		                    	Curso cCreate = new Curso();
		                    	System.out.println("Nome do Curso");
		            			cCreate.setTitle(scanner.next());
		            			System.out.println("ID do Departamento");
		            			cCreate.setId_department(scanner.nextInt());
		            			System.out.println("Valor do curso");
		            			cCreate.setCredit(scanner.nextFloat());
		            			
		            			boolean c_res_create = Curso.create(cCreate);
		            			System.out.println(c_res_create + " CURSO CRIADO COM SUCESSO");
		            			System.out.println("");
		            			
		            			break;
		            			
		                    case 2:
			                	System.out.println("Deletar Curso");
			                	System.out.println("Informe o ID do curso");
			                	
			                	boolean c_res_delete = Curso.delete(scanner.nextInt());
			                	System.out.println(c_res_delete + " CURSO DELETADO COM SUCESSO");
			                	System.out.println("");
			                	
			                    break;
			                    
		                    case 3:
			                	System.out.println("Atualizar Curso");
			                	Curso cUpdate = new Curso();
			                	System.out.println("Informe o ID do curso");
			        			cUpdate.setId_curso(scanner.nextInt());
			        			System.out.println("Atualize o titulo do curso");
			        			cUpdate.setTitle(scanner.next());
			        			System.out.println("Atualize o ID do departamento");
			        			cUpdate.setId_department(scanner.nextInt());
			        			System.out.println("Atualize o valor do curso");
			        			cUpdate.setCredit(scanner.nextFloat());
			        		
			        			boolean c_res_update = Curso.update(cUpdate);
			        			System.out.println(c_res_update + " CURSO ATUALIZADO COM SUCESSO");
			        			System.out.println("");
			        			
			                    break;
			                    
		                    case 4:
								System.out.println("Buscar Curso");
			  		            System.out.println("Informe o ID do Curso");
			  		            Curso cSelect = Curso.getById(scanner.nextInt());
			  		            System.out.println("");
			  		            System.out.println("Nome do Curso: " + cSelect.getTitle());
			  		            System.out.println("ID do departamento: " + cSelect.getId_department());
			  		            System.out.println("Valor do curso: " + cSelect.getCredit());
			  		            System.out.println("");
			                    break;
			                    
		                    case 5:   
			                    ArrayList<Curso> Cursos = Curso.listAll();
									for(Curso c : Cursos) {
										System.out.println("");
										System.out.println("ID do Curso: " + c.getId_curso());
										System.out.println("Nome do Curso: " + c.getTitle());
										System.out.println("ID do departamento: " + c.getId_department());
										System.out.println("Valor do curso: " + c.getCredit());
										System.out.println("");
									}
			        			
			        			break;
			                    
		                    default:
			                    System.out.println("---ERROR---");  
		                  
		                    }
		                    
	                    }
	                    
	                case 3:
	                	
	                	int numEstudante = 0;
	                	
	                	while(numEstudante != 9) {
	                		System.out.println("");
	                		System.out.println("Tabela Estudante");
							System.out.println("");
		                    System.out.println("Escolha a operação");
							System.out.println("");
		                    System.out.println("1- Criar Estudante");
		                    System.out.println("2- Deletar Estudante");
		                    System.out.println("3- Atualizar Estudante");
		                    System.out.println("4- Buscar Estudante");
		                    System.out.println("5- Mostrar todos os estudantes");
		                    System.out.println("9- Voltar");
		           
		                    numEstudante= scanner.nextInt();
		                   
		                    switch(numEstudante) {
		                    
		                    case 1:
		                    	System.out.println("Criar Estudante");
		                    	Estudante sCreate = new Estudante();
		                    	System.out.println("Nome do Estudante");
		            			sCreate.setName_estudante(scanner.next());
		            			System.out.println("ID do Departamento");
		            			sCreate.setId_department(scanner.nextInt());
		            			
		            			
		            			boolean s_res_create = Estudante.create(sCreate);
		            			System.out.println(s_res_create + " ESTUDANTE CRIADO COM SUCESSO");
		            			System.out.println("");
		            			
		            			break;
		            			
		                    case 2:
			                	System.out.println("Deletar Estudante");
			                	System.out.println("Informe o ID do estudante");
			                	
			                	boolean s_res_delete = Estudante.delete(scanner.nextInt());
			                	System.out.println(s_res_delete + " ESTUDANTE DELETADO COM SUCESSO");
			                	System.out.println("");
			                	
			                    break;
			                    
		                    case 3:
			                	System.out.println("Atualizar Estudante");
			                	Estudante sUpdate = new Estudante();
			                	System.out.println("Informe o ID do estudante");
			        			sUpdate.setId_estudante(scanner.nextInt());
			        			System.out.println("Atualize o nome do estudante");
			        			sUpdate.setName_estudante(scanner.next());
			        			System.out.println("Atualize o ID do departamento");
			        			sUpdate.setId_department(scanner.nextInt());
			        		
			        			boolean s_res_update = Estudante.update(sUpdate);
			        			System.out.println(s_res_update + " ESTUDANTE ATUALIZADO COM SUCESSO");
			        			System.out.println("");
			        			
			                    break;
			                    
		                    case 4:
			                	System.out.println("Buscar Estudante");
			                	
			  		            System.out.println("Informe o ID do Estudante");
			  		            Estudante sSelect = Estudante.getById(scanner.nextInt());
			  		            System.out.println("");
			  		            System.out.println("Nome do Estudante: " + sSelect.getName_estudante());
			  		            System.out.println("ID do departamento: " + sSelect.getId_department());
			  		            System.out.println("");
			                    break;
			                    
		                    case 5:   
			                    ArrayList<Estudante> Estudantes = Estudante.listAll();
			        			for(Estudante s : Estudantes) {
			        				System.out.println("");
				  		            System.out.println("");
				  		            System.out.println("ID do Estudante: " + s.getId_estudante());
				  		            System.out.println("Nome do Estudante: " + s.getName_estudante());
				  		            System.out.println("ID do departamento: " + s.getId_department());
				  		            System.out.println("");
				  		            System.out.println("");
			        			}
			        			
			        			break;
			                    
		                    default:
			                    System.out.println("---ERROR---");  
		                  
		                    }
	                	}
	                    
	                default:
	                    System.out.println("---ERROR---");    
	                
		            }
			 }
			System.out.println(department.close() + " Department close");
			System.out.println(Curso.close() + " Curso close");
			System.out.println(Estudante.close() + " Estudante close");
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
}