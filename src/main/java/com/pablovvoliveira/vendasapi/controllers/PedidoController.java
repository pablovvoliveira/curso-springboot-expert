package com.pablovvoliveira.vendasapi.controllers;

import static org.springframework.http.HttpStatus.*;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pablovvoliveira.vendasapi.DTO.InfoItemPedidoDTO;
import com.pablovvoliveira.vendasapi.DTO.InfoPedidoDTO;
import com.pablovvoliveira.vendasapi.DTO.PedidoDTO;
import com.pablovvoliveira.vendasapi.entity.ItemPedido;
import com.pablovvoliveira.vendasapi.entity.Pedido;
import com.pablovvoliveira.vendasapi.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@PostMapping
	@ResponseStatus(CREATED)
	public Integer save(@RequestBody PedidoDTO dto) {
		Pedido pedido = service.salvar(dto);
		return pedido.getId();
	}
	
	@GetMapping("/{id}")
	public InfoPedidoDTO getById(@PathVariable Integer id) {
		return service
				.obterPedidoCompleto(id)
				.map(p -> converter(p))
				.orElseThrow(() ->
						new ResponseStatusException(NOT_FOUND, "Pedido não encontrado."));
				
	}
	
	private InfoPedidoDTO converter(Pedido pedido) {
		return InfoPedidoDTO
			.builder()
			.codigo(pedido.getId())
			.dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
			.cpf(pedido.getCliente().getCpf())
			.nomeCliente(pedido.getCliente().getNome())
			.total(pedido.getTotal())
			.itens(converter(pedido.getItens()))
			.build();
	}
	
	private List<InfoItemPedidoDTO> converter(List<ItemPedido> itens) {
		if(CollectionUtils.isEmpty(itens)) {
			return Collections.emptyList();
		}
		return itens.stream().map(
					item -> InfoItemPedidoDTO
					.builder()
					.descricaoProduto(item.getProduto().getDescricao())
					.precoUnitario(item.getProduto().getPreco())
					.quantidade(item.getQuantidade())
					.build()
					).collect(Collectors.toList());
	}
		
}
