package com.pierre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pierre.data.vo.ProdutoVO;
import com.pierre.repositories.ProdutoRepository;

@Service
public class ProdutoServices {
	
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoServices(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public ProdutoVO create(ProdutoVO produtoVO) {
		
		return null;
	}
	
	
	

}
