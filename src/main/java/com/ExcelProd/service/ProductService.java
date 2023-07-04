package com.ExcelProd.service;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ExcelProd.entity.Product;
import com.ExcelProd.helper.ProductHelper;
import com.ExcelProd.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productrepo;
	
	public void save(MultipartFile file) {
	
		try
		{
			List<Product> products = ProductHelper.convertExcelToListOfProduct(file.getInputStream());
			this.productrepo.saveAll(products);
			
		}catch (IOException e)
	
		{
			e.printStackTrace();
		}
	}
	
	public List<Product> getAllProducts()
	{
		return this.productrepo.findAll();
	}
}
