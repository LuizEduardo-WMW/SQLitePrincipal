package domain;

public class Venda {


	public int numeroDoPedido; // 
	public int codigo; //
	public String nomeDoCliente;
	public String sabor; //NUMERIC, DEFINIDO PELA OUTRA TABELA NO BANCO (SORVETES)
	public double valorUnidade; //NUMERIC, VALOR POR CADA VENDA DEFINIDO PELA OUTRA TABELA NO BANCO (SORVETES)
	public double valorVenda; //NUMERIC, VALOR POR VENDA, SOMADO AUTOMATICAMENTE QUANDO SELECIONA A QUANTIDADE DE VENDA (ESTOQUEVENDA) 
	public double valorTotal; //NUMERIC, VALOR TOTAL DE VENDAS, SOMADO AUTOMATICAMENTE NO RELATORIO DE VENDAS
	public double estoqueAtivo;//NUMERIC, VALOR DE ESTOQUE DISPONIVEL PARA CONSEGUIR VENDER
	public double estoqueVenda; //NUMERIC, ESTOQUE POR VENDA, SOMADO AUTOMATICAMENTE QUANDO SELECIONA A QUANTIDADE DE VENDA (ESTOQUEVENDA) 
	public double estoqueVendido; //NUMERIC, VALOR DE ESTOQUE TOTAL DE VENDAS

	public double estoquePosVenda;

	
	
}
