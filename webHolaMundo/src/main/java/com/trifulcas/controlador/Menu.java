package com.trifulcas.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("entrantes", "<p>Sopa de calabaza</p><p>Ensalada de la casa</b><p>Cacahuetes</p>");
		request.setAttribute("segundos", "<p>Entrecot</p><p>Dorada a la plancha</b><p>Salchichas</p>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int res=0;
		for (int i=0;i<10000;i++) {
			res+=i;
		}
		response.setContentType("text/html");//setting the content type  
		PrintWriter pw=response.getWriter();
		pw.print("<h1>"+res+"</h1>");
		pw.close();
	}

}
