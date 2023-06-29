package com.pablovvoliveira.vendasapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pablovvoliveira.vendasapi.services.PedidoService;

@RestController("/api/pedidos")
public class PedidoController {
	
	private PedidoService service;
}
