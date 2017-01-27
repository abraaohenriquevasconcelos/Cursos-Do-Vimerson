package br.edu.fatecsjc;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ServletError
 */
@WebServlet(urlPatterns={"/error"})
public class ServletError extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public ServletError() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String codigoError = request.getParameter("codigoError");
		
		if(codigoError.equals("104")){
			response.setContentType("text/html");
			response.getWriter().append("<h1><span style='color: red;'>Error: "+codigoError+"</span></h1>");
		}else{
			request.getRequestDispatcher("./inicio.jsp").forward(request, response);;
		}
		
		
	}

}
