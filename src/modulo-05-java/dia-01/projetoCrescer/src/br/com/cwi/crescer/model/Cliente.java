package br.com.cwi.crescer.model;

public class Cliente {
    
    private Long idCliente;
	private String nmCliente;
	private String nrCPF;
	
	public Long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNmCliente() {
		return nmCliente;
	}
	
	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}
	
	public String getNrCPF() {
		return nrCPF;
	}
	
	public void setNrCPF(String nrCPF) {
		this.nrCPF = nrCPF;
	}
	
}
