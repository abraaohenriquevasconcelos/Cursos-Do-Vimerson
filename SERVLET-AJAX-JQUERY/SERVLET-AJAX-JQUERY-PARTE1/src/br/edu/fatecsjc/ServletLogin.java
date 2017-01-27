package br.edu.fatecsjc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/login"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.getWriter().append("GET").append("\n\n");
		//response.getWriter().append("Parâmetro \"usuario\": ").append(request.getParameter("usuario")).append("\n\n");
		//response.getWriter().append("Parâmetro \"senha\": ").append(request.getParameter("senha"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//tipo de formato ou mime type
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if(!usuario.equals("")){
			PrintWriter writer = response.getWriter();
			writer.println("<html><body><br/><br/><h3>ServletLogin</h3><br/>Usuário: "+usuario+"</body></html>");
			writer.close();
		}else{
			response.sendRedirect("error?codigoError=105");//redirecionamos a para o servlet de erro
		}
		
	}

}
