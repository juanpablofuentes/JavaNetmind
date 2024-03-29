package com.trifulcas.clases;

import com.trifulcas.ejercitos.Ejercito;

public class ProbarClases {

	public static void main(String[] args) {
		
		Animal[] granja= {new Perro(),new Gato(),new Pato()};
		Audio[] parque= {new Automovil(), new Monociclo(),new Instrumento()};
		
		Financiero[] empresa= {new Banco(),new Sueldo(),new Banco()};
		
		Perro p=new Perro();
		
		
		
		for(Financiero f:empresa) {
			System.out.println(f.interes());
		}
		
		Banco b=new Banco();
		Sueldo s=new Sueldo();
		
		System.out.println(importe(b,1000));
		System.out.println(importe(s,2000));
		
		Movimiento miCarro=new Automovil();
		
		for(Animal animal:granja) {
			animal.sonido();
		}
		for(Audio vehiculo:parque) {
			vehiculo.sonido();
		}
		
		Automovil auto=new Automovil();
		Instrumento violin=new Instrumento();
		
		repetir(auto,3);
		repetir(violin,8);
	}
	
	// El par�metro 'elemento' debe ser de una clase que implemente el
	// interfaz 'Financiero' obligatoriamente yo s� que ese par�metro
	// tendr� definidos los m�todos 'interes' y 'irpf'
	public static double importe(Financiero elemento, double importe) {
		return elemento.interes()*importe;
	}
	
	public static void repetir(Audio elemento, int veces) {
		for(int i=0;i<veces;i++) {
			elemento.sonido();
		}
	}
}