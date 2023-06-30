package com.pablovvoliveira.vendasapi.services;

import com.pablovvoliveira.vendasapi.DTO.PedidoDTO;
import com.pablovvoliveira.vendasapi.entity.Pedido;

public interface PedidoService {
	
	Pedido salvar(PedidoDTO dto);
}
