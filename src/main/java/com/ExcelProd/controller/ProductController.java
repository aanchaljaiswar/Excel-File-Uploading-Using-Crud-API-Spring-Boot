package com.ExcelProd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ExcelProd.entity.Product;
import com.ExcelProd.helper.ProductHelper;
import com.ExcelProd.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@PostMapping("/product/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)
	{
		if(ProductHelper.checkExcelFormat(file))
		{
			this.productservice.save(file);
			
			Map<String, String> responseMap = new HashMap<>();
			responseMap.put("k1", "message");
			responseMap.put("v1", "File is uploaded and data is saved to db");

			return ResponseEntity.ok(responseMap);
			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
	}

	@GetMapping("/product")
	
	public List<Product> getAllProduct()
	{
		return this.productservice.getAllProducts();
	}
}
