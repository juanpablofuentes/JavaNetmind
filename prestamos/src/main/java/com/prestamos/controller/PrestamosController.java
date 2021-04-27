package com.prestamos.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prestamos.dao.Prestamos;
import com.prestamos.dao.PrestamosDAO;

/**
 * Servlet implementation class PrestamosController
 */
@WebServlet("/prestamos")
public class PrestamosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrestamosDAO modelo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrestamosController() {
		super();
		modelo = new PrestamosDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		System.out.println(accion);
		if (accion==null) {
			accion="";
		}
		if (accion.equals("nuevo")) {
			// Pondré el código para mostrar la página para introducir los nuevos datos
			RequestDispatcher dispatcher = request.getRequestDispatcher("nuevo.jsp");
			dispatcher.forward(request, response);
		} else if (accion.equals("insertar")) {
			// Aquí recuperaré los datos y los añadiré a la base de datos
			System.out.println("Hola, preparado para insertar");
			
			// Recupero los datos que me pasan
			String nombre=request.getParameter("nombre");
			String titulo=request.getParameter("titulo");
			Date fecha=Date.valueOf(request.getParameter("fecha"));
			
			// Tengo que darlos de alta en la base de datos ¿Cómo?
			// Con el modelo
			Prestamos nuevo=new Prestamos(0,nombre,titulo,fecha);
			modelo.addPrestamo(nuevo);
			request.setAttribute("prestamos", modelo.getPrestamos());
			RequestDispatcher dispatcher = request.getRequestDispatcher("prestamos.jsp");
			dispatcher.forward(request, response);
			
		} else if (accion.equals("borrar")) {
			// Recupero el id y elimino el registro
			System.out.println("Aquí hay que borrar");
			
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			modelo.deletePrestamo(id);
			response.sendRedirect("./prestamos");
			
		} else if (accion.equals("editar")) {
			// Recuperaré el registro que tenga el id que me pasan y
			// Mandaré los datos a una página para que el usuario los modifique
			System.out.println("recuperar los datos (id) y formulario editar");
			int id=Integer.parseInt(request.getParameter("id"));
			Prestamos prestamo=modelo.getPrestamo(id);
			request.setAttribute("prestamo", prestamo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
			dispatcher.forward(request, response);
			
		} else if (accion.equals("modificar")) {
			// Recupero los datos que me pasan y modifico el registro en la base de datos
			System.out.println("recuperar los datos (id,nombre,titulo,fecha) y modificar en la base de datos");
			
			int idprestamos=Integer.parseInt(request.getParameter("idprestamos"));
			String nombre=request.getParameter("nombre");
			String titulo=request.getParameter("titulo");
			Date fecha=Date.valueOf(request.getParameter("fecha"));
			Prestamos editar=new Prestamos(idprestamos,nombre,titulo,fecha);
			modelo.updatePrestamo(editar);
			response.sendRedirect("./prestamos");
		} else {
			request.setAttribute("prestamos", modelo.getPrestamos());
			RequestDispatcher dispatcher = request.getRequestDispatcher("prestamos.jsp");
			dispatcher.forward(request, response);
		}
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
