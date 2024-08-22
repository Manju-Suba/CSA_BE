package com.csa.cs.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.csa.cs.response.ApiResponse;



public interface MastersService {
	  public ResponseEntity<ApiResponse> createUom( String name) throws IOException ;
	  public ResponseEntity<ApiResponse> viewUom() throws IOException ;
	  public ResponseEntity<ApiResponse> getUom(Long id) throws IOException ;
	  public ResponseEntity<ApiResponse> updateUom( Long id,String name) throws IOException ;
	  
}
