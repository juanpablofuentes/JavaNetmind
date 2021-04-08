package com.trifulcas.clases;


// Definiendo un interface con un método
interface Audio {
	// Este método es como un método abstracto de una clase abstracta
	// Las clases que implementen este interfaz deben implementar el método
	void sonido();
}

interface Movimiento{
	void acelerar();
	void frenar();
}


class Automovil implements Audio,Movimiento {

	@Override
	public void sonido() {
		System.out.println("brum brum");
	}

	@Override
	public void acelerar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void frenar() {
		// TODO Auto-generated method stub
		
	}

}

class Monociclo  implements Audio  {

	@Override
	public void sonido() {
		System.out.println("Dring dring");

	}

}

class Avion implements Audio{

	@Override
	public void sonido() {
		// TODO Auto-generated method stub
		
	}
	
}