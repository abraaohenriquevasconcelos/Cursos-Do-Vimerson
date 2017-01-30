package br.edu.fatecsjc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/login"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.getWriter().append("GET").append("\n\n");
		//response.getWriter().append("Parâmetro \"usuario\": ").append(request.getParameter("usuario")).append("\n\n");
		//response.getWriter().append("Parâmetro \"senha\": ").append(request.getParameter("senha"));

	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//tipo de formato ou mime type
		
		/************************************************************************************************* 
		 *************************************************************************************************/
		
		/*Pense no HttpSession como uma região de memória compartilhada por todas as requisições feitas
		  pelo mesmo usuário. Os dados não são armazenados automaticamente na HttpSession. O Java EE tem
		  a classe HttpSession que tem um HashMap estruturada(Dicionário) e pode armazenar qualquer tipo
		  de objeto nele de modo que ele pode ser compartilhado por diferentes páginas.
		  
		  º    -> Pagina A    --------->          -----------------------
		 -|-   -> Pagina B	  ---------> 		  | HttpSessio  		|
		  /\   -> Pagina C	  --------->    	  |	------------------  |
		  										  |	|"key": "value"	 |	|
		  										  |	|________________|	|
		  										  -----------------------
		  Cada vez que um usuário cria uma sessão, depois disso é enviado para o navegador do usuário um cookie usado para identificar e 
		  associar o HashMap que acabou de ser criado. Esse HashMap pode ser acessado a partir de qualquer outra página. O conceito de Sessão
		  é individual para cada usuário que se conecta a nossa aplicação e as informações não são compartilhadas entre eles. Assim, cada
		  usuário terá seu próprio HashMap para armazenar informações que são úteis entre as páginas.
		  Usuário A -> HttpSession A -> Cookie A
		  Usuário B -> HttpSession B -> Cookie B
		  A sessão é implementada no servlet container. Se os cookies estiverem desabilitados, a sessão não funcionará. A sessão nada nais é que um tempo
		  em que o usuário permanece ativo no sistema. A cada página visitada, o tempo de sessão é zerado. Quando o tempo ultrapassa um limite demarcado
		  no arquivo web.xml, o cliente perde sua sessão.
		  
		  Para obter um objeto HttpSession usamos o método getSession do objeto javax.servlet.http.HttpServletRequest. Ao obter o objeto HttpSession pela
		  primeira vez, o recurso Gerenciamento de Sessão utiliza uma entre três maneiras para estabelecer o rastreamento da sessão: cookies,
		  regravação de URL ou informações SSL(Secure Sockets Layer).Suponhamos que o recurso Gerenciamento de Sessão utilize cookies. Nesse caso, o recurso Gerenciamento de Sessão cria
		  um ID de sessão exclusivo e, geralmente, o envia de volta ao navegador como um cookie. Depois de uma sessão ser 
		  estabelecida, você pode adicionar e recuperar dados definidos pelo usuário para a sessão. O objeto HttpSession possui
		  métodos semelhantes àqueles do java.util.Dictionary. Um servlet pode ler, por exemplo, um objeto inteiro do 
		  HttpSession, incrementá-lo de gravá-lo de volta. É possível utilizar qualquer nome para identificar valores no objeto HttpSession 
		  */
		
		//HttpSession session = request.getSession();//Objeto HttpSession
		
	
		if(!request.getParameter("usuario").equals("")){
			
			PrintWriter writer = response.getWriter();
			writer.println("<html><body><br/><br/><h3>ServletLogin</h3><br/>Usuário: "+request.getParameter("usuario")+"</body></html>");
			writer.close();
		}else{
			request.getSession().setAttribute("mensagem", "Safado");
			response.sendRedirect("error?codigoError=104");//redirecionamos a para o servlet de erro
		}
		
	}

}
