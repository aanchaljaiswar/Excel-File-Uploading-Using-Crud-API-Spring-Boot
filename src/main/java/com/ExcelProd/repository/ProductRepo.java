package com.ExcelProd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExcelProd.entity.Product;

public interface ProductRepo extends JpaRepository <Product,Integer> {

}
