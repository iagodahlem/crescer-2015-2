package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDAO;
import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.dao.ServicoDAO;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.mapper.ProdutoMapper;

@Service
public class ProdutoService {

	private ProdutoDAO produtoDAO;
	private MaterialDAO materialDAO;
	private ServicoDAO servicoDAO;
	
	@Autowired
	public ProdutoService(ProdutoDAO produtoDAO, MaterialDAO materialDAO, ServicoDAO servicoDAO) {
		this.produtoDAO = produtoDAO;
		this.materialDAO = materialDAO;
		this.servicoDAO = servicoDAO;
	}
	
	public ProdutoDTO buscarPorId(Long id) {
		return new ProdutoDTO(produtoDAO.findById(id));
	}
	
	public List<ProdutoDTO> listarTodos() {
		List<Produto> produtos = produtoDAO.listAll();

		List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
		for (Produto produto : produtos) {
			produtosDTO.add(new ProdutoDTO(produto));
		}

		return produtosDTO;
	}
	
	public List<ProdutoDTO> listarPorMaterialEServico(String material, String servico) {
		
		List<Produto> produtos = produtoDAO.listByMaterialEServico(material, servico);

		List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
		for (Produto produto: produtos) {
			produtosDTO.add(new ProdutoDTO(produto));
		}

		return produtosDTO;
	}
	
	public void inserir(ProdutoDTO produtoDTO) {

		Produto produto = ProdutoMapper.getNewEntity(produtoDTO);
		produto.setMaterial(materialDAO.findById(produtoDTO.getIdMaterial()));
		produto.setServico(servicoDAO.findById(produtoDTO.getIdServico()));
		produto.setSituacao(SituacaoProduto.ATIVO);

		produtoDAO.save(produto);
	}
	
	public void atualizar(ProdutoDTO produtoDTO) {

		Produto produto = produtoDAO.findById(produtoDTO.getId());
		ProdutoMapper.merge(produtoDTO, produto);
		produto.setSituacao(produtoDTO.getSituacao());

		produtoDAO.save(produto);
	}
	
	public List<SituacaoProduto> listarSituacoes() {
		List<SituacaoProduto> situacoes = new ArrayList<SituacaoProduto>();
		situacoes.add(SituacaoProduto.ATIVO);
		situacoes.add(SituacaoProduto.INATIVO);
		return situacoes;
	}
	
}
