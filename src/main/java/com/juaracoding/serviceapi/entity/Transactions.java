package com.juaracoding.serviceapi.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(	name = "transactions")
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int insurance_price;
	private int shipping_price;
	private int total_price;
	private String transaction_status;
	private String code;

	@ManyToOne
    @JoinColumn(name="users_id")
    private User user;
	
	@OneToOne(mappedBy = "transaction")
    private TransactionDetails transaction_details;
}
