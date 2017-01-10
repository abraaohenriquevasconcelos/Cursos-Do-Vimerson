import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.fatecsjc.model.Usuario;

public class TesteHibernate {

	public static void main(String[] args) {
		//O EntityManagerFactory lê o arquivo "persistence.xml" e faz a configuração inicial 	
		//o atributo "name" que colocamos pra propriedade "persistence-unit" é o parâmetro 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vimerson2");
		
		/*
		 ***********************************************************************************************
		 ************************************************************************************************
		 ************************************************************************************************
		*/
		
		//Já que o emf é uma fabrica de EntityManager pedimos pra ele criar um EntityManager
		//No final das contas o EntityManager é o objeto do Hibernate que vai gerenciar as entidades,salvar, excluir, montar sql
		//Diferente do modelo DAO onde cada classe tem o seu, com o objeto EntityManager do Hibernate, qualquer classe que tenha a anotação @Entity é persistida por esse objeto
		EntityManager em = emf.createEntityManager();
		
		
		/*
		 ***********************************************************************************************
		 ************************************************************************************************
		 ************************************************************************************************
		*/
		
		
		//Criamos um usuario que vai ser persistido
		Usuario usuario = new Usuario();
		usuario.setNome("Maria");
		usuario.setUsuario("maria");
		usuario.setSenha("123");
		
		
		/*
		 ***********************************************************************************************
		 ************************************************************************************************
		 ************************************************************************************************
		*/
		
		
		//Vamos iniciar uma transação
		//Uma transação é um conjunto de ações que vão acontecer no banco de dados
		//Uma transação é um conjunto de instruções sql 
		em.getTransaction().begin();//getTransaction(): EntityTransaction
		
		
		/*
		 ***********************************************************************************************
		 ************************************************************************************************
		 ************************************************************************************************
		*/
		
		
		//Prepara a instrução sql e adiciona ela na transação
		em.persist(usuario);//aqui estamos fazendo um "insert"
		
		
		/*
		 ***********************************************************************************************
		 ************************************************************************************************
		 ************************************************************************************************
		*/
		
		
		em.getTransaction().commit();//confirmando a transação no banco. Fazendo a persistência no banco
	}

}
