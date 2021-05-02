package com.pierre.pagamento.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.pierre.pagamento.data.vo.ProdutoVendaVO;

@Entity
@Table(name = "produtoVenda")
public class ProdutoVenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_produto", nullable = false, length = 10)
	private Long idProduto;
	
	@Column(name = "qantidade", nullable = false, length = 10)
	private Integer qantidade;
	
	//ManyToOne)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_venda")
	private Venda venda;
	
	public ProdutoVenda() {
		
	}

	public ProdutoVenda(Long id, Long idProduto, Integer qantidade) {
		super();
		this.id = id;
		this.idProduto = idProduto;
		this.qantidade = qantidade;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public void setQantidade(Integer qantidade) {
		this.qantidade = qantidade;
	}
	
	

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
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
		ProdutoVenda other = (ProdutoVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProdutoVenda [id=" + id + ", idProduto=" + idProduto + ", qantidade=" + qantidade + "]";
	}
	
	public static ProdutoVenda create(ProdutoVendaVO produtoVendaVO) {
		return new ModelMapper().map(produtoVendaVO, ProdutoVenda.class);
	}
	
}
