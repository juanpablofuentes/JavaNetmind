package com.trifulcas.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trifulcas.dao.Autor;
import com.trifulcas.dao.Circulo;

/**
 * Servlet implementation class Ejemplo
 */
@WebServlet({"/Ejemplo","/ejemplo","/Ejemplos","/ejemplos"})
public class Ejemplo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doget");
		request.setAttribute("nombre", "Juan");
		
		Autor ana=new Autor("Ana","Pi");
		Circulo circulo=new Circulo(1);
		request.setAttribute("autor", ana);
		request.setAttribute("circulo", circulo);

		int[] datos= {2,5,1,8,4,2,3};
		request.setAttribute("datos", datos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ejemploServlet.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
