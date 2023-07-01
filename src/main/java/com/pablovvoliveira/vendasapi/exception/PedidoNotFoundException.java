package com.pablovvoliveira.vendasapi.exception;

public class PedidoNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PedidoNotFoundException() {
		super("Pedido não encontrado");
	}
}
