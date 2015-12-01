package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.dto.PedidoDTO;

public class PedidoMapper {

	public static Pedido getNewEntity(PedidoDTO dto) {
		Pedido entity = new Pedido();
        entity.setDataInclusao(dto.getDataInclusao());
        return entity;
    }

    public static PedidoDTO toDTO(Pedido entity) {
    	PedidoDTO dto = new PedidoDTO();
        return dto;
    }
	
    public static Pedido merge(PedidoDTO dto, Pedido entity) {
        return entity;
    }
	
}
