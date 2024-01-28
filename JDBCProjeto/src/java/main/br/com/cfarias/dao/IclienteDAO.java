package br.com.cfarias.dao;

import java.util.List;

import br.com.cfarias.domain.Cliente;

public interface IclienteDAO {
	
	public Integer cadastrarCliente(Cliente cliente) throws Exception;

	public Cliente consultarCliente(String codigo) throws Exception;

	public Integer excluir(Cliente cliente) throws Exception;
	
	public Integer atualizarCliente(Cliente cliente) throws Exception;
	
	public List <Cliente> buscarTodos() throws Exception;
	
	
	

}
