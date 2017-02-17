package vimerson.foda.controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vimerson.foda.model.Cliente;

/*
Servlets são objetos java capazes de receber as requisições do browser e devolver respostas. Então 
fazemos uma requisição http e resposta http. O servlet vai receber os dados do cliente dentro de  
um cabeçalho http. Quem vai instanciar o servlet é um servlet container. Um servlet container é um 
servidor que vai receber/interceptar as requisições http, pois ele já tem pronto uma série de tare 
fas de comunicação http e transformar essas informações em objetos java, vamos dar um objeto java 
pro servlet container e ele vai entregar em http pro browser. Quem faz a tradução entre http e  
objetos java é o http. A própria biblioteca JRE Standard Edition não tem servlet. No nosso  
computador existe uma pasta oculta ".m2" que guarda todas as dependências que já usamos do maven.
Seguindo a estrutura MVC o servlet vai representar a camada de controle.  
*/
@WebServlet(value="/clientes")
public class ClienteController extends HttpServlet{
	
	/*
	 ********************************************************************************************
	 ******************************************************************************************** 
	 ********************************************************************************************
	*/
								/*Parte das Regras de Negócio*/
	
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private int idGerado = 1;
	
	
	private Cliente cadastrarCliente(Cliente cli){
		cli.setId(idGerado++);
		listaCliente.add(cli);
		return cli;
	}
	
	/*
	 ********************************************************************************************
	 ******************************************************************************************** 
	 ********************************************************************************************
	*/
	
							/*Parte do Controller*/
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Os campos do formulário vão chegar aqui no servlet como parâmetros do cabeçalho http.	O cabeçalho
		//http tem cum "head" e um "body". E para recuperar os dados do cabeçalho http usamos o objeto request 
	
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		Cliente cli = new Cliente();
		cli.setNome(nome);
		cli.setEmail(email);
		
		cli = cadastrarCliente(cli);
		
		response.getWriter().println("Id:"+cli.getId()+"\n"+"Nome:"+nome);
		
		/**Para testar esse "post" podemos montar um cabeçalho http e fazer as requisições**/
	}
	
	/*
	 ********************************************************************************************
	 ******************************************************************************************** 
	 ********************************************************************************************
	*/
	
	
}
