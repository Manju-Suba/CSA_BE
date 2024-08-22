package com.csa.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csa.cs.model.Uom;

public interface UomRepository extends JpaRepository<Uom, Long>{

//	boolean existsByUomNameAndIdNot(String name, Long id);

}
