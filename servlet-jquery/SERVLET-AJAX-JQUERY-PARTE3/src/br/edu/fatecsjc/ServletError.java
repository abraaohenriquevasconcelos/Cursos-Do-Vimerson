package br.edu.fatecsjc;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet implementation class ServletError
 */
@WebServlet(urlPatterns={"/error"})
public class ServletError extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
  
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String codigoError = request.getParameter("codigoError");
		
		if(codigoError.equals("104")){
			HttpServletRequest requestHttp = (HttpServletRequest) request;
			response.setContentType("text/html");
			response.getWriter().append("<h1><span style='color: red;'>Error: "+codigoError+"</span>, "+requestHttp.getSession().getAttribute("mensagem")+"</h1>");
		}else{
			/*
			  As funcionalidades das ações forward e include são bem semelhantes. O "forward" serve para transferir o controle para outro
			  componente web (servlet/JSP). Você deve lembrar como ele funciona: redireciona seus objetos request e response para o recurso
			  que você aponta no getRequestDispatcher. Por isso ele só pode ser chamado uma vez pelo seu servlet, porque ele delega toda a
			  responsabilidade da requisição para outro servlet ou JSP. Isto também significa que ele só pode ser redirecionado para um
			  servlet/JSP por vez. Se você tentar executar qualquer método após o forward, terá uma exceção. Já o include serve para incluir
			  recursos web na sua página atual (Objeto response). É no response que ele age principalmente, pode ser chamado muitas vezes.
			  Ex.:
			  RequestDispatcher dispatcher = request.getRequestDispatcher("pag2.jsp");
			  dispatcher.include(request, response);
			  dispatcher = request.getRequestDispatcher("pag3.jsp");
			  dispatcher.include(request, response);
			  Isso fará tanto a página pag2.jsp quanto a pag3.jsp serem incluídas na sua página de retorno para o usuário (response)
			  Lembre-se: "include" não redireciona, apenas inclui, por isso você pode usá-lo e continuar executando código logo após, porque
			  ainda está no mesmo recurso web - no caso, no seu servlet;
			 */
			request.getRequestDispatcher("./inicio.jsp").forward(request, response);;
		}
		
		
	}

}
