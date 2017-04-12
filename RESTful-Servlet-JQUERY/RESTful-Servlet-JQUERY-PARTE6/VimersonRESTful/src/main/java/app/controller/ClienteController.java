package app.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Cliente;


/*
 Agora os servlets vão ficar escondidos dentro do framework
 @Controller -> Associamos essa anotação com classes que possuem métodos que processam requests numa 
 aplicação web.
 */
//@RestController(value="/clientes")
@RestController
public class ClienteController{
	
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private int idGerado = 1;
	
	
	private Cliente cadastrarCliente(Cliente cli){
		cli.setId(idGerado++);
		listaCliente.add(cli);
		return cli;
	}
	
	private Cliente buscarCliente(Integer id){
		for(Cliente c : listaCliente){
			if(c.getId().equals(id)){ return c; }
		}
		return null;
	}
	
	
	private Cliente alterarCliente(Cliente cliente){
		int indice = buscarIndiceCliente(cliente);
		
		if(indice != -1)
			listaCliente.set(indice, cliente);
		
		return cliente;
	}
	
	private int buscarIndiceCliente(Cliente cliente){
		for(int i = 0; i < listaCliente.size(); i++){
			if(cliente.getId().equals(listaCliente.get(i).getId())){ return i; }
		}
		return -1;
	}
	
	private void excluirCliente(Integer id){
		Cliente c = new Cliente();
		c.setId(id);
		int indice = buscarIndiceCliente(c);
		listaCliente.remove(indice);
	}
	
	/*
	 ********************************************************************************************
	 ******************************************************************************************** 
	 ********************************************************************************************
	*/
	
							
	
	/*
	 @RequestMapping geralmente utilizada em cima dos métodos de uma classe anotada com @Controller
	 Serve para você colocar os endereços da sua aplicação que, quando acessados por algum cliente,
	 deverão ser direcionados para o determinado método.
	 */
	@RequestMapping(value="/clientes", method=RequestMethod.POST)
	public Cliente cadastrar(@RequestBody Cliente cliente){
		/*
		 A anotação @ResquestBody significa que o framework vai tirar os dados do cliente do corpo da
		 requisição. Ou seja, o framework vai arrancar do corpo da requisição e jogar dentro da variável
		 do tipo cliente. Então @RequestBody quer dizer que não estamos passando os dados na url e sim
		 no corpo do cabeçalho http. E é o Jackson quem vai transforma de json para objeto Java
		 
		 **String nome = request.getParameter("nome");**   -> PASSADO
		 **String email = request.getParameter("email");** -> PASSADO
		 Agora o "request" está com o framework então os dados do request o framework vai injetar no 
		 parâmetro "cliente". Automaticamente o framework vai extrair um cliente dentro do cabeçalho 
		 http
		 
		 ResponseEntity é um objeto próprio para montar uma resposta http
		 
		 @RequestMapping é para fazer um mapeamento de requisição
		 */

		cliente = cadastrarCliente(cliente);
		
		return cliente;
	}
	
	/*
	 ********************************************************************************************
	 ******************************************************************************************** 
	 ********************************************************************************************
	*/
	
	@RequestMapping(value="/clientes", method=RequestMethod.GET)
	public List<Cliente> listar(){
		return listaCliente;
	}
	
	/*
	 ********************************************************************************************
	 ******************************************************************************************** 
	 ********************************************************************************************
	*/
	
	@RequestMapping(value="/clientes/{id}", method = RequestMethod.GET)
	public Cliente buscarPorId(@PathVariable("id") Integer id){
		/*
		 @PathVariable pega uma variável que está vindo na url 
		 */
		return buscarCliente(id);
	}
	
	/*
	 ********************************************************************************************
	 ******************************************************************************************** 
	 ********************************************************************************************
	*/
	
	@RequestMapping(value="/clientes", method = RequestMethod.PUT)
	public Cliente alterar(@RequestBody Cliente cliente){
		//@RequestBody pega os dados do corpo do cabeçalho http e não da url
		cliente = alterarCliente(cliente);
		return cliente;
	}
	
	
	@RequestMapping(value="/clientes/{id}", method= RequestMethod.DELETE)
	public void excluir(@PathVariable("id") Integer id){
		excluirCliente(id);
	}
}
