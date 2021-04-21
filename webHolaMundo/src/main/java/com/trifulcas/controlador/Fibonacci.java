package com.trifulcas.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trifulcas.utils.Sucesiones;

/**
 * Servlet implementation class Fibonacci
 */
@WebServlet("/fibonacci")
public class Fibonacci extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Fibonacci() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String terminos = request.getParameter("terminos");
		int term=0;
		if (terminos != null && terminos.chars().allMatch(Character::isDigit)) {
			term=Integer.parseInt(terminos);
		} else {
			term = 20;
		}
		request.setAttribute("sucesion", Sucesiones.fibonacci(term));
		request.setAttribute("terminos", term);
		RequestDispatcher dispatcher = request.getRequestDispatcher("fibonacci.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
