package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
@CrossOrigin(origins= {" * "}, maxAge=6000)
@Api(tags = {"Encore Product"})
public class myProductRestController {
	
	@Autowired
	private MyProductService service;
	
	@ApiOperation(value="모든 상품 반환", response=List.class)
	@GetMapping("findProducts")
	public ResponseEntity<List<MyProduct>> findAllProducts() throws Exception{
		List<MyProduct> products = service.findProducts();
		if(products.isEmpty()) return new ResponseEntity<List<MyProduct>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MyProduct>>(products, HttpStatus.OK);
	}
	
	@ApiOperation(value="특정한 이름이 들어간 상품을 찾는다", response=List.class)
	@GetMapping("findByProductName/{name}")
	public ResponseEntity<List<MyProduct>> findProductByName(@PathVariable String name) throws Exception{
		List<MyProduct> product = service.findByProductName(name);
		if(product==null) return new ResponseEntity<List<MyProduct>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MyProduct>>(product, HttpStatus.OK);
	}
	
	@ApiOperation(value="특정한 제조사가 들어간 상품을 찾는다", response=List.class)
	@GetMapping("findByProductMaker/{maker}")
	public ResponseEntity<List<MyProduct>> findProductByMaker(@PathVariable String maker) throws Exception{
		List<MyProduct> product = service.findByProductMaker(maker);
		if(product==null) return new ResponseEntity<List<MyProduct>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MyProduct>>(product, HttpStatus.OK);
	}
	
	@ApiOperation(value="상품 추가", response=MyProduct.class)
	@PostMapping("addProduct")
	public ResponseEntity addProduct(@RequestBody MyProduct vo) throws Exception{
		service.addProduct(vo);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@ApiOperation(value="상품 수정", response=MyProduct.class)
	@PutMapping("updateProduct")
	public ResponseEntity<MyProduct> updateProduct(@RequestBody MyProduct vo) throws Exception{
		boolean result = service.updateProduct(vo);
		if(!result) return new ResponseEntity<MyProduct>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<MyProduct>(HttpStatus.OK);
	}
	
	@ApiOperation(value="상품 삭제", response=MyProduct.class)
	@DeleteMapping("deleteProduct/{id}")
	public ResponseEntity<MyProduct> deleteProduct(@RequestBody int id) throws Exception{
		boolean result = service.deleteProduct(id);
		if(!result) return new ResponseEntity<MyProduct>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<MyProduct>(HttpStatus.OK);
	}
	
	
	

}
