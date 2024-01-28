package br.com.cfarias.dao;

import java.util.List;

import br.com.cfarias.domain.Cliente;
import br.com.cfarias.domain.Produto;

public interface IprodutoDAO {
	
	public Integer cadastrarProduto(Produto produto) throws Exception;

	public Produto consultarProduto(String codigo) throws Exception;

	public Integer excluirProduto(Produto produto) throws Exception;
	
	public Integer atualizarProduto(Produto produto) throws Exception;
	
	public List <Produto> buscarTodosProdutos() throws Exception;
	

}
