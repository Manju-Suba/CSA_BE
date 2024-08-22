package com.csa.cs.serviceImplementation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.csa.cs.model.Uom;
import com.csa.cs.repository.UomRepository;
import com.csa.cs.response.ApiResponse;
import com.csa.cs.service.MastersService;

@Service
public class MastersServiceImplementations implements MastersService {
	@Autowired
	private UomRepository uomrepo;
	
	@Override
	public ResponseEntity<ApiResponse> viewUom() throws IOException {
	       try {
	    	   List<Uom> vaultdata = uomrepo.findAll();
		    	 if (vaultdata.isEmpty()) {
		               // return new ApiResponse(false, "created successfully",
		               // Collections.emptyList());
		               return ResponseEntity.status(HttpStatus.OK)
		                       .body(new ApiResponse(true, "Vault Datas Not Found", Collections.emptyList()));
		   		
		   	    }
		    	   return ResponseEntity.status(HttpStatus.CREATED)
	                        .body(new ApiResponse(true, "Uom fetched successfully", vaultdata));
		    	 
			}  catch (Exception e) {
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			            .body(new ApiResponse(false, e.getMessage(), Collections.emptyList()));
			}
			}
			   

	@Override
	public ResponseEntity<ApiResponse> getUom( Long id) throws IOException {
		  try {
	            Uom uom = uomrepo.findById(id).orElse(null);

	            if (uom!=null) {
	                return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, "Fetched successfully", uom));
	            } else {
	                return ResponseEntity.status(HttpStatus.OK)
	                        .body(new ApiResponse(true, "Uom does not exist ", Collections.emptyList()));
	            }

	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body(new ApiResponse(false, e.getMessage(), Collections.emptyList()));
	        }
	}



	
	@Override
	public ResponseEntity<ApiResponse> createUom(String name) throws IOException {

		    try {
		        Uom uomcreate = new Uom();
		        LocalDateTime currentTime = LocalDateTime.now();
		        uomcreate.setUomname(name);
		        uomcreate.setCreatedby(currentTime);
		        uomcreate.setUpdatedby(currentTime);
		        uomrepo.save(uomcreate);
		        
		        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new ApiResponse(true, "created successfully", uomcreate));
		    } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body(new ApiResponse(false, e.getMessage(), Collections.emptyList()));
	        }
	}


	@Override
	public ResponseEntity<ApiResponse> updateUom(Long id, String name) throws IOException {
		// TODO Auto-generated method stub
		  try {
//	            if (uomrepo.existsByNameAndIdNot(name, id)) {
//	                return ResponseEntity.status(HttpStatus.CONFLICT)
//	                        .body(new ApiResponse(false, "Try Another Name", Collections.emptyList()));
//	            }
	            Uom uom = uomrepo.findById(id).orElse(null);
	            uom.setUomname(name);
	            uomrepo.save(uom);
	            return ResponseEntity.status(HttpStatus.OK)
                        .body(new ApiResponse(true, "Updated successfully", uom));
	        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(false, e.getMessage(), Collections.emptyList()));
        }

	      }
	

}
