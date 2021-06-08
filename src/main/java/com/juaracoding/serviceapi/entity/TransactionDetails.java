package com.juaracoding.serviceapi.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(	name = "transaction_details")
public class TransactionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int price;
	private int shipping_status;
	private int resi;
	private String code;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transactions_id", referencedColumnName = "id")
    private Transactions transaction;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    private Products product;
}
