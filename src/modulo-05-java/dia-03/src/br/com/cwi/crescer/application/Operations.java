package br.com.cwi.crescer.application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Pedido;

public class Operations {
	
	ClienteDao clienteDao = new DaoBase().CriarClienteDao();
	PedidoDao pedidoDao = new DaoBase().CriarPedidoDao();
	
	public Cliente selecionarCliente() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nº | Nome");
		System.out.println("---------");
		
		List<Cliente> list = clienteDao.listAll();
    	for (Cliente cliente : list) {
    		System.out.println(cliente.getIdCliente() + "  - " + cliente.getNmCliente());
    	}
    	
    	System.out.println("\n" + "Digite o numero do cliente... ");
    	
    	Long idCliente = scanner.nextLong();
    	Cliente cliente = clienteDao.load(idCliente);
    	
    	return cliente;
    	
	}
	
	public void inserirPedidoSelecionandoCliente() throws SQLException {
		inserirPedido(selecionarCliente());
	}
	
	public Cliente inserirCliente() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		Cliente cliente = new Cliente();
		System.out.println("Digite o nome do cliente... ");
		cliente.setNmCliente(scanner.nextLine());
		System.out.println("Digite o CPF do cliente... ");
		cliente.setNrCPF(scanner.nextLine());
		
		clienteDao.insert(cliente);
		
		System.out.println("Cliente inserido com sucesso.");
		
		return cliente;
	}
	
	public void inserirPedidoCriandoCliente() throws SQLException {
		inserirPedido(inserirCliente());
	}
	
	public void inserirPedido(Cliente cliente) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite a descrição do pedido... ");
		
		Pedido pedido = new Pedido();
		
		Long idCliente = cliente.getIdCliente();
		String nomeCliente = cliente.getNmCliente();
		
		if (idCliente != null) {
			pedido.setIdCliente(idCliente);
		}
		else {
			idCliente = clienteDao.loadByName(nomeCliente).getIdCliente();
			pedido.setIdCliente(idCliente);
		}
		
		pedido.setDsPedido(scanner.nextLine());
		
		pedidoDao.insert(pedido);
		
		System.out.println("Pedido inserido com sucesso.");
		
	}
	
	public void listarPedidosDeDeterminadoCliente() throws SQLException {
		
		Cliente cliente = selecionarCliente();
		Long idCliente = cliente.getIdCliente();
		
		System.out.println("Nº Pedido | Nº Cliente | Descrição");
		System.out.println("----------------------------------");
		
		List<Pedido> list = pedidoDao.listByCliente(idCliente);
		if (list != null) {
			for (Pedido pedido : list) {
	    		System.out.println(pedido.getIdPedido() + " - " + pedido.getIdCliente() + " - " + pedido.getDsPedido());
	    	}	
		}
		else {
			System.out.println("Nenhum pedido encontrado");
		}
    	
	}
	
	public void buscarPedido() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n" + "Digite o numero do pedido... ");
		
		Long idPedido = scanner.nextLong();
		
		Pedido pedido = pedidoDao.load(idPedido);
		
		if (pedido != null) {
			System.out.println("Nº Pedido: " + pedido.getIdPedido());
			System.out.println("Nº Cliente: " + pedido.getIdCliente());
			System.out.println("Descrição: " + pedido.getDsPedido());
		}
		else {
			System.out.println("Nenhum pedido encontrado.");
		}
    	
	}
	
}
