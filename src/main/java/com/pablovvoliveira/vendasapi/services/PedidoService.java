package com.pablovvoliveira.vendasapi.services;

import java.util.Optional;

import com.pablovvoliveira.vendasapi.DTO.PedidoDTO;
import com.pablovvoliveira.vendasapi.entity.Pedido;
import com.pablovvoliveira.vendasapi.enums.StatusPedido;

public interface PedidoService {
	
	Pedido salvar(PedidoDTO dto);
	
	Optional<Pedido> obterPedidoCompleto(Integer id);
	
	void updateStatus(Integer id, StatusPedido statusPedido);
}
