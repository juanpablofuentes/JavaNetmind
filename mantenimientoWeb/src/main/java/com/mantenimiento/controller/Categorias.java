package com.mantenimiento.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mantenimiento.dao.Categoria;
import com.mantenimiento.dao.CategoriaDAO;

/**
 * Servlet implementation class Categorias
 */
@WebServlet("/categorias")
public class Categorias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoriaDAO modelo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Categorias() {
		super();
		modelo = new CategoriaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Tendré que tener una serie de urls para el mantenimiento CRUD
		// Cuando me pongan esa url tendré que hacer lo que haga falta

		// EJemplo: si yo quiero añadir una categoría tendré dos 'pantallas'
		// 1) Un formulario que nos pida los datos de la categoría: accion=nueva
		// 2) Una acción que recupere esos datos y dé de alta la categoría
		// accion=insertar
		String accion = request.getParameter("accion");
		if (accion == null) {
			accion = "";
		}
		Integer id;
		switch (accion) {
		case "nueva":
			response.sendRedirect("categoria_nueva.jsp");
			break;
		case "insertar":
			System.out.println("Insertar");
			String nombre = request.getParameter("nombre");
			System.out.println(nombre);
			modelo.addCategoria(nombre);
			response.sendRedirect("categorias");
			break;

		case "editar":
			id = Integer.parseInt(request.getParameter("id"));
			if (id != null) {
				Categoria cat = modelo.getCategoria(id);
				request.setAttribute("categoria", cat);
				RequestDispatcher dispatcher = request.getRequestDispatcher("categoria_editar.jsp");
				dispatcher.forward(request, response);

			}
			break;
		case "actualizar":
			System.out.println("Actualizar");
			String nombre2 = request.getParameter("nombre");
			id = Integer.parseInt(request.getParameter("id"));
			Categoria cat = new Categoria(id, nombre2);
			System.out.println(nombre2);
			modelo.updateCategoria(cat);
			response.sendRedirect("categorias");
			break;
		case "borrar":
			System.out.println("Eliminar");
			id = Integer.parseInt(request.getParameter("id"));
			if (id != null) {
				modelo.deleteCategoria(id);
			}
			response.sendRedirect("categorias");
			break;

		default:
			List<Categoria> categorias = modelo.getCategorias();
			request.setAttribute("categorias", categorias);
			RequestDispatcher dispatcher = request.getRequestDispatcher("categorias.jsp");
			dispatcher.forward(request, response);

			break;
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
