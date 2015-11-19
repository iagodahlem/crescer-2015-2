package br.com.cwi.crescer.application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Pedido;

public class Operations {
	
	public void selecionarCliente() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nº - Nome");
		System.out.println("---------");
		
		ClienteDao clienteDao = new ClienteDao();
		List<Cliente> list = clienteDao.listAll();
    	for (Cliente cliente : list) {
    		System.out.println(cliente.getIdCliente() + "  - " + cliente.getNmCliente());
    	}
    	
    	System.out.println("\n" + "Digite o numero do cliente que deseja incluir no pedido... ");
    	
    	Long idCliente = scanner.nextLong();
    	Cliente cliente = clienteDao.load(idCliente);
    	
    	inserirPedido(cliente);
    	
	}
	
	public void inserirCliente() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		Cliente cliente = new Cliente();
		System.out.println("Digite o nome do cliente... ");
		cliente.setNmCliente(scanner.nextLine());
		System.out.println("Digite o CPF do cliente... ");
		cliente.setNrCPF(scanner.nextLine());
		
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.insert(cliente);
		
		inserirPedido(cliente);
		
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
			ClienteDao clienteDao = new ClienteDao();
			idCliente = clienteDao.loadByName(nomeCliente).getIdCliente();
			pedido.setIdCliente(idCliente);
		}
		
		pedido.setDsPedido(scanner.nextLine());
		
		PedidoDao pedidoDao = new PedidoDao();
		pedidoDao.insert(pedido);
		
	}
	
}
