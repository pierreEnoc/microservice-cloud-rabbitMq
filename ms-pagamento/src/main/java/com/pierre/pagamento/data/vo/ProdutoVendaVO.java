package com.pierre.pagamento.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pierre.pagamento.entities.ProdutoVenda;

@JsonPropertyOrder({"id","idProduto","qantidade"})
public class ProdutoVendaVO extends RepresentationModel<ProdutoVendaVO> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("idProduto")
	private Long idProduto;
	
	@JsonProperty("quantidade")
	private Integer qantidade;
	
	public ProdutoVendaVO() {
		
	}

	public ProdutoVendaVO(Long id, Long idProduto, Integer qantidade) {
		super();
		this.id = id;
		this.idProduto = idProduto;
		this.qantidade = qantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getQantidade() {
		return qantidade;
	}

	public void setQantidade(Integer qantidade) {
		this.qantidade = qantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoVendaVO other = (ProdutoVendaVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProdutoVendaVO [id=" + id + ", idProduto=" + idProduto + ", qantidade=" + qantidade + "]";
	}
	
	public static ProdutoVendaVO creste(ProdutoVenda produtoVenda) {
		return new ModelMapper().map(produtoVenda, ProdutoVendaVO.class);
	}
	
}
