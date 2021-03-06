package com.trifulcas.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trifulcas.dao.Autor;

/**
 * Servlet implementation class Prueba
 */
@WebServlet({ "/pepito", "/juanito" })
public class Prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("importe", 500);
		request.setAttribute("cantidad", 7);
		request.setAttribute("cantidad", 17);
		request.setAttribute("producto", "Madalenas (muy buenas)");
		// Pasamos una lista
		List<String> alumnos=new ArrayList<String>();
		alumnos.add("Eva");
		alumnos.add("Ana");
		alumnos.add("Juan");
		request.setAttribute("alumnos", alumnos);
		
		//Pasamos un array
		int[] notas= {1,4,2,7};
		request.setAttribute("notas", notas);
		
		//Pasamos un objeto
		Autor pepe=new Autor("Pepe","Pi");
		request.setAttribute("autor", pepe);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jstl.jsp");
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
