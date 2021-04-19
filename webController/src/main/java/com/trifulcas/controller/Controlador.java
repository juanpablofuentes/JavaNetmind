package com.trifulcas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cadena= request.getParameter("cadena");
		boolean palindromo=false;
		System.out.println(cadena);
		if (cadena!=null) {
			palindromo=esPalindromo(cadena);
			System.out.println(palindromo);
		}
		request.setAttribute("palindromo", palindromo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("palindromo.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public  boolean esPalindromo(String cadena) {
        cadena = normalizar(cadena);
        StringBuilder foo = new StringBuilder(cadena);
        return cadena.equals(foo.reverse().toString());
    }
     
    // He creado una función normalizar para otros caracteres
    public  String normalizar(String cadena) {
        return cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
                .replace("ú", "u").replace("ü","u").replace(" ", "").replace(".", "").replace(",", "");
    }

}
