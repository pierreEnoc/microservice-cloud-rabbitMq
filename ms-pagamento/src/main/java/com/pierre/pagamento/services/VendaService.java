package com.pierre.pagamento.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pierre.pagamento.data.vo.VendaVO;
import com.pierre.pagamento.entities.ProdutoVenda;
import com.pierre.pagamento.entities.Venda;
import com.pierre.pagamento.exception.ResourceNotFoundException;
import com.pierre.pagamento.repositories.ProdutoVendaRepository;
import com.pierre.pagamento.repositories.VendaRepository;

@Service
public class VendaService {
	
	private final VendaRepository vendaRepository;
	private final ProdutoVendaRepository produtoVendaRepository;

	@Autowired
	public VendaService(VendaRepository vendaRepository,ProdutoVendaRepository produtoVendaRepository) {
		this.vendaRepository = vendaRepository;
		this.produtoVendaRepository =  produtoVendaRepository;
	}
	
	public VendaVO create(VendaVO vendaVO) {
		Venda venda = vendaRepository.save(Venda.create(vendaVO));
		
		List<ProdutoVenda> produtosSalvos =  new ArrayList<>();
		vendaVO.getProdutos().forEach(p -> {
			ProdutoVenda pv = ProdutoVenda.create(p);
			pv.setVenda(venda);
			produtosSalvos.add(produtoVendaRepository.save(pv));
		});
		venda.setProdutos(produtosSalvos);
		
		return VendaVO.create(venda);
	}
	
	public Page<VendaVO> findAll(Pageable pageable) {
		var page = vendaRepository.findAll(pageable);
		return page.map(this::convertToVendaVO);
	}
	
	private VendaVO convertToVendaVO(Venda venda) {
		return VendaVO.create(venda);
	}
	
	public VendaVO findById(Long id) {
		var entity = vendaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		return VendaVO.create(entity);
	}
	
	public VendaVO update(VendaVO vendaVO) {
		final Optional<Venda> optionalProduto = vendaRepository.findById(vendaVO.getId());
		
		if(!optionalProduto.isPresent()) {
			new ResourceNotFoundException("No records found for this Id");
		}
		return VendaVO.create(vendaRepository.save(Venda.create(vendaVO)));
	}
	
	public void delete(Long id) {
		var entity = vendaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		vendaRepository.delete(entity);
	}

}
