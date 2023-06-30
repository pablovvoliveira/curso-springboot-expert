package com.pablovvoliveira.vendasapi.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pablovvoliveira.vendasapi.DTO.ItemPedidoDTO;
import com.pablovvoliveira.vendasapi.DTO.PedidoDTO;
import com.pablovvoliveira.vendasapi.entity.Cliente;
import com.pablovvoliveira.vendasapi.entity.ItemPedido;
import com.pablovvoliveira.vendasapi.entity.Pedido;
import com.pablovvoliveira.vendasapi.entity.Produto;
import com.pablovvoliveira.vendasapi.exception.RegraNegocioException;
import com.pablovvoliveira.vendasapi.repositories.Clienterepository;
import com.pablovvoliveira.vendasapi.repositories.ItemPedidoRepository;
import com.pablovvoliveira.vendasapi.repositories.PedidoRepository;
import com.pablovvoliveira.vendasapi.repositories.ProdutoRepository;
import com.pablovvoliveira.vendasapi.services.PedidoService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceimpl implements PedidoService{
	
	private final PedidoRepository pedidoRepository;
	private final Clienterepository clienteRepository;
	private final ProdutoRepository produtoRepository;
	private final ItemPedidoRepository itemPedidoRepository;

	@Override
	@Transactional
	public Pedido salvar(PedidoDTO dto) {
		Integer idCliente = dto.getCliente();
		Cliente cliente  = clienteRepository
				.findById(idCliente)
				.orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));
		
		Pedido pedido = new Pedido();
		pedido.setTotal(dto.getTotal());
		pedido.setDataPedido(LocalDate.now());
		pedido.setCliente(cliente);
		
		List<ItemPedido> itemPedido = converterItens(pedido, dto.getItens());
		pedidoRepository.save(pedido);
		itemPedidoRepository.saveAll(itemPedido);
		pedido.setItens(itemPedido);
		return pedido;
	}
	
	private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> items) {
		if(items.isEmpty()) {
			throw new RegraNegocioException("Não é possível realizar um pedido sem itens.");
		}
		
		return items
				.stream()
				.map(dto -> {
					Integer idProduto = dto.getProduto();
					Produto produto = produtoRepository
					.findById(idProduto)
					.orElseThrow(() -> new RegraNegocioException("Código de produto inválido: " + idProduto));
					
					ItemPedido itemPedido = new ItemPedido();
					itemPedido.setQuantidade(dto.getQuantidade());
					itemPedido.setPedido(pedido);
					itemPedido.setProduto(produto);
					return itemPedido;
				}).collect(Collectors.toList());
		
	}
	
}
