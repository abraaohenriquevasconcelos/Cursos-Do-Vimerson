package br.edu.fatecsjc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.fatecsjc.model.Usuario;

public class UsuarioDAO {
	
	EntityManager entityManager;
	
	public UsuarioDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	
	

	public void salvar(Usuario usuario){
		//Se o usuario possui id o método "merge" vai tentar fazer update
		//Se ele não possui id o método "merge" vai fazer insert
		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();
	}
	
	
	public Usuario buscarPorId(int id){
		//Utilizando o JDBC puro fica assim:
		/*
		 Usuario usuario = null;
		 String sql = "Select * from usuario where...
		 try(PreparedStatement preparador = con...
		*/
		
		
		//entityManager faça uma busca utilizando a classe Usuario.class pra montar o sql
		//e utilize o id do parâmetro
		return entityManager.find(Usuario.class, id);
	}
	
	
	public List<Usuario> buscarTodos(){
		//Cada classe com @Entity está vinculada a uma tabela 
		//No JPA existe JPQL que é a linguagem "SQL" das entidades
		//Então o JPQL do JPA faz consultas em cima das entidades e não das tabelas do banco
		Query query = entityManager.createQuery("select u from Usuario u");
		//Agora queremos convert
		return query.getResultList(); //getResultList(): List
	}
	
	
	public void excluir(Usuario usuario){
		entityManager.getTransaction().begin();
		entityManager.remove(usuario);
		entityManager.getTransaction().commit();
	}
}
