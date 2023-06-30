package com.pablovvoliveira.vendasapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {
	
	private Integer produto;
	private Integer quantidade;
}
