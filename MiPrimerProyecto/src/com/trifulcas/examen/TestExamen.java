package com.trifulcas.examen;

public class TestExamen {
	public static void main(String[] args) {

		// Prueba de números complejos
		Complejo pepe = new Complejo(3, 4);
		Complejo a = new Complejo(13.34, 4.98);
		Complejo b = new Complejo(0.04, 100.06);
		Complejo c = new Complejo(0, 0);

		System.out.println(pepe); // 3.0+4.0i
		System.out.println(a); // 13.34+4.98i
		System.out.println(b); // 0.04+100.06i
		System.out.println(c); // 0.0+0.0i

		System.out.println(pepe.modulo()); // 5.0
		System.out.println(c.modulo()); // 0.0

		// Prueba de clases abstractas
		// Alimento al=new Alimento("Kiwi",100); No se puede hacer porque la clase es
		// abstracta

		Verduras brocoli = new Verduras("Brócoli", 90);
		Carnes pechuga = new Carnes("Pechuga de pollo", 125);
		Procesados lasagna = new Procesados("Lasaña barbacoa", 600);

		System.out.println(brocoli); // Alimento [nombre=Brócoli, calorias=90, factor=0.7]
		System.out.println(pechuga); // Carnes Alimento [nombre=Pechuga de pollo, calorias=125, factor=0.9]
		System.out.println(lasagna); // Alimento [nombre=Lasaña barbacoa, calorias=600, factor=1.4]

		Alimento mongeta = new Verduras("Mongeta tendra", 60);
		
		Verduras h=new Verduras("...",2);
		Alimento g=new Verduras(",,,",3);
		
		
		System.out.println(h.tonto());  // Esto sí porque es verdura
		// Esto no porque es alimento System.out.println(g.tonto());
		
		g=new Carnes("---",5); //Esto lo puedo hacer porque es Alimento
		// Esto no lo puedo hacer porque es verdura h=new Carnes("---",5);
		
		System.out.println(dieta(brocoli, 200));
		System.out.println(dieta(pechuga, 300));
		System.out.println(dieta(mongeta, 300));
		System.out.println(mongeta);
		
		CestaCompra cesta=new CestaCompra();
		
		cesta.comprar(brocoli);
		cesta.comprar(pechuga);
		
		cesta.comprarguay(mongeta, 20);
		System.out.println(cesta);
		
		System.out.println(cesta.valorNutricional());
		System.out.println(cesta.valorNutricionalguay());
		
		Libro quijote=new Libro("El quijote","Cervantes",600);
		Revista muyInteresante=new Revista("Muy interesante",120);
		Estadisticas jojo=new Comic("Jojo's bizarre adventures","Manga",320);
		
		System.out.println(quijote);
		
		System.out.println(quijote.tiempoLectura());
		System.out.println(quijote.mediaPalabras());
		System.out.println(muyInteresante.tiempoLectura());
		
		Pila miPila=new Pila();
		
		miPila.addItem(quijote);
		miPila.addItem(jojo);
		System.out.println(miPila);
		System.out.println(miPila.totalTiempo());
		
		System.out.println(miPila.fechaFin());
	}

	public static boolean dieta(Alimento al, int cantidad) {
		if (al instanceof Verduras) {
			System.out.println(al.getNombre()+" es una verdura");
			System.out.println(((Verduras)al).tonto());
		}
		return al.valorNutricional(cantidad) < 1200;
	}
}
