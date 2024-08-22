package com.csa.cs.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csa.cs.response.ApiResponse;
import com.csa.cs.service.MastersService;



@CrossOrigin
@RestController
@RequestMapping("/api/masters")
public class MastersController {
	
	@Autowired
	private MastersService masterservice;
    @GetMapping("/create_uom")
    public ResponseEntity<ApiResponse> createUom(@RequestParam (required = true) String name) throws IOException {
    	return masterservice.createUom(name) ;
    }
    
    @GetMapping("/view_uom")
    public ResponseEntity<ApiResponse> viewUom() throws IOException {
    	return masterservice.viewUom() ;
    }
    
    @GetMapping("/get_uom")
    public ResponseEntity<ApiResponse> getUom(@RequestParam(required = true) Long id) throws IOException {
    	return masterservice.getUom(id);
    }
    
    @GetMapping("/update_uom")
    public ResponseEntity<ApiResponse> updateUom(@RequestParam (required = true) String name,Long id) throws IOException {
    	return masterservice.updateUom(id,name) ;
    }

}
