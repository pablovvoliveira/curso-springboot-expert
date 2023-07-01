package com.pablovvoliveira.vendasapi.services;

import java.util.Optional;

import com.pablovvoliveira.vendasapi.DTO.PedidoDTO;
import com.pablovvoliveira.vendasapi.entity.Pedido;

public interface PedidoService {
	
	Pedido salvar(PedidoDTO dto);
	
	Optional<Pedido> obterPedidoCompleto(Integer id);
}
