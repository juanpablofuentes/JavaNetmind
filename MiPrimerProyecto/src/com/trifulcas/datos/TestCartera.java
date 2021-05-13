package com.trifulcas.datos;

public class TestCartera {

	public static void main(String[] args) {
		MonedaDAO moneda=new MonedaDAO();
		
		System.out.println(moneda.getMoneda(1));

		CarteraDAO cartera = new CarteraDAO();
		
		System.out.println(cartera.getCartera(1));
		System.out.println(cartera.getCartera(1).getCantidad()*cartera.getCartera(1).getMoneda().getValor());
		System.out.println(cartera.getCartera(2));
		System.out.println(cartera.getCartera(3));
		System.out.println(cartera.getCarteraUsuario(1));
		UsuarioDAO usuario=new UsuarioDAO();
		Usuario ana=usuario.getUsuario(1);
		for(Cartera cart:ana.getCartera()) {
			System.out.println(cart);
			System.out.println(cart.getMoneda().getNombre());
			System.out.println(cart.getCantidad()*cart.getMoneda().getValor());
		}
		System.out.println(usuario.getUsuario(1));
		System.out.println(usuario.getUsuario(2));
	}

}
