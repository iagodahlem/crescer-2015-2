package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.ProdutoDTO;

public class ProdutoMapper {

	public static Produto getNewEntity(ProdutoDTO dto) {
        Produto entity = new Produto();
        entity.setPrazo(dto.getPrazo());
        entity.setValor(dto.getValor());
        return entity;
    }

    public static ClienteDTO toDTO(Cliente entity) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getIdCliente());
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setEmail(entity.getEmail());
        dto.setIdCidade(entity.getCidade().getIdCidade());
        return dto;
    }
	
    public static Produto merge(ProdutoDTO dto, Produto entity) {
        entity.setPrazo(dto.getPrazo());
        entity.setValor(dto.getValor());
        return entity;
    }
    
}
