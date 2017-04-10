package com.revature.caliber.training.web.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.training.beans.Category;
import com.revature.caliber.training.service.BusinessDelegate;

/**
 * Category Controller
 * 
 *
 */
@RestController
@CrossOrigin(origins = { "*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.OPTIONS }, allowedHeaders = { "X-PINGOTHER", "Content-Type" }, maxAge = 10)
public class CategoryController {

	private static Logger log = Logger.getLogger(BatchController.class);
	private BusinessDelegate businessDelegate;

	@Autowired
	public void setBusinessDelegate(BusinessDelegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	/**
	 * Request to get a Category 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "category/byCategoryId/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpEntity<Category> getCategory(@PathVariable("id") Integer id){
		ResponseEntity<Category> returnEntity;
		try {
			Category categories = businessDelegate.getCategory(id);
			if (categories == null)
				returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
			else
				returnEntity = new ResponseEntity<>(categories, HttpStatus.OK);
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
			log.error("Runtime Exception.", e);
		}
		return returnEntity;
	}
	
	/**
	 * Request to get all categories
	 * @return
	 */
	@RequestMapping(value = "categories/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpEntity<List<Category>> getAllCategories() {
		ResponseEntity<List<Category>> returnEntity;
		try {
			List<Category> categories = businessDelegate.getAllCategories();
			if (categories == null)
				returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
			else
				returnEntity = new ResponseEntity<>(categories, HttpStatus.OK);
		} catch (RuntimeException e) {
			returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
			log.error("Runtime Exception.", e);
		}
		return returnEntity;
	}
}
