package com.trifulcas.datos;


import java.util.List;
import java.util.Scanner;

public class AccesoDAO {

	public static void main(String[] args) {

		try {
			// He abstraído la base de datos
			// Sólo tengo que crear una instancia de mi capa de Datos
			ActorDAO bd = new ActorDAO();

			Scanner in = new Scanner(System.in);
			int res = 0;
			do {
				System.out.println(
						"1.- Buscar actores\n2.- Añadir actores\n3.- Modificar actores\n4.- Eliminar\n0.- Salir");
				res = in.nextInt();
				String nombre, apellido;
				int actor_id;
				switch (res) {
				case 1:
					System.out.println("Buscar actores");

					System.out.println("Dime una parte el apellido");
					String cad = in.next();
					List<Actor> actores = bd.getActors(cad);
					for (Actor actor : actores) {
						System.out.println(actor);
					}

					break;
				case 2:
					System.out.println("Añadir actores");
					System.out.println("Dime el nombre");
					nombre = in.next();
					System.out.println("Dime el apellido");
					apellido = in.next();

					if (bd.addActor(new Actor(0, nombre, apellido, null))) {
						System.out.println("Registro insertado");
					} else {
						System.out.println("No se ha insertado el registro");
					}

					break;
				case 3:
					System.out.println("Modificar actores");
					System.out.println("Dime el id del actor que quieres modificar");
					actor_id = in.nextInt();
					System.out.println("Dime el nombre");
					nombre = in.next();
					System.out.println("Dime el apellido");
					apellido = in.next();

					if (bd.updateActor(new Actor(actor_id, nombre, apellido, null))) {
						System.out.println("Registro modificado");
					} else {
						System.out.println("No se ha modificado el registro");
					}
					break;
				case 4:
					System.out.println("Eliminar actores");
					System.out.println("Dime el id del actor que quieres eliminar");
					actor_id = in.nextInt();
					if (bd.deleteActor(actor_id)) {
						System.out.println("Registro eliminado");
					} else {
						System.out.println("No se ha eliminado el registro");
					}
					break;
				}
			} while (res != 0);

		} catch (Exception ex) {

			System.out.println(ex);
		}
	}

}
