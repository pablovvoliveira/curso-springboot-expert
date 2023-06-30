package com.pablovvoliveira.vendasapi.controllers;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pablovvoliveira.vendasapi.DTO.PedidoDTO;
import com.pablovvoliveira.vendasapi.entity.Pedido;
import com.pablovvoliveira.vendasapi.services.PedidoService;

@RestController("/api/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@PostMapping
	@ResponseStatus(CREATED)
	public Integer save(@RequestBody PedidoDTO dto) {
		Pedido pedido = service.salvar(dto);
		return pedido.getId();
	}
}
