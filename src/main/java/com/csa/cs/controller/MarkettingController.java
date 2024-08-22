package com.csa.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csa.cs.response.ApiResponse;



@CrossOrigin
@RestController
@RequestMapping("/marketting")
public class MarkettingController {
	
	    @GetMapping("/create_npd")
	    public ApiResponse createNpd() {
	    	return null;
	    }
	
}
