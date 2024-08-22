package com.csa.cs.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "npd_basics")
public class NpdBasic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "VARCHAR(85)")
	private String product_name;
	
	@Column(length = 50)
	private Integer plant_id;
	
	@Column(columnDefinition = "VARCHAR(25)")
	private String volume;
	
	@Column(columnDefinition = "TEXT(10)")
	private String volume_approval;
	
	private Integer uom_id;
	
	@Column(columnDefinition = "VARCHAR(25)")
	private String case_configuration;
	
	@Column(columnDefinition = "TEXT(15)")
	private String case_approval;
	
	@Column(columnDefinition = "VARCHAR(10)")
	private String quantity;
	
	@Column(columnDefinition = "TEXT(10)")
	private String quantity_approval;
	
	private String mrp;
	
	@Column(columnDefinition = "TEXT(10)")
	private String mrp_price_approval;
	
	private Integer dist_channel;
	
	@Column(columnDefinition = "VARCHAR(10)")
	private String specific_gravity;
	
	@Column(columnDefinition = "VARCHAR(10)")
	private String total_rm_cost;
	
	@Column(columnDefinition = "VARCHAR(10)")
	private String conv_cost;
	
	@Column(columnDefinition = "TEXT(10)")
	private String conv_cost_approval;
	
	@Column(columnDefinition = "VARCHAR(10)")
	private String conv_uom;
	
	@Column(columnDefinition = "VARCHAR(50)")
	private String breakup_excel;
	
	@Column(columnDefinition = "VARCHAR(10)")
	private String sales_tax;
	
	@Column(columnDefinition = "TEXT(10)")
	private String stax_approval;
	
	@Column(columnDefinition = "VARCHAR(5)")
	private String hsn_code;
	
	@Column(columnDefinition = "VARCHAR(10)")
	private String damage;
	
	@Column(columnDefinition = "TEXT(10)")
	private String damage_approval;
	
	@Column(columnDefinition = "VARCHAR(10)")
	private String logistic;
	
	@Column(columnDefinition = "TEXT(10)")
	private String logistic_approval;
	
	@Column(columnDefinition = "TEXT(10)")
	private String mt_csheet_approval;
	
	@Column(columnDefinition = "TEXT(10)")
	private String csheet_approval;
	
	@Column(columnDefinition = "VARCHAR(5)")
	private String status;
	
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
}
