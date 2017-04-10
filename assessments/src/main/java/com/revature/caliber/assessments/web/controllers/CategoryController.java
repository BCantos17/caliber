package com.revature.caliber.assessments.web.controllers;

import com.revature.caliber.assessments.beans.Category;
import com.revature.caliber.assessments.service.BusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController    // infers @ResponseBody on all methods && @Controller
@CrossOrigin(origins = {"*"},
        methods = {RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE},
        allowedHeaders = {"X-PINGOTHER", "Content-Type"},
        maxAge = 10)
public class CategoryController {

    private BusinessDelegate delegate;

    //Spring setter based DI
    @Autowired
    public void setDelegate(BusinessDelegate delegate) {
        this.delegate = delegate;
    }

    // getAllCategories
    @RequestMapping(
            value = "/category/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Category>> getAll() {
        Set<Category> categories = delegate.getAllCategories();
        if (categories.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // getCategoryById
    @RequestMapping(
            value = "/category/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getById(@PathVariable("id") int id) {
        Category category = delegate.getCategoryById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
