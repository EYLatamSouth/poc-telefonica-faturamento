package br.com.telefonica.faturamento.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Billing {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billing_id;
	
	@Column(nullable = false)
	private Integer customer_id;
	
	@Column(nullable = false)
	private LocalDate billing_vencimento;
	
	@Column(nullable = false)
	private String billing_status;
	
	@Column(nullable = false)
	private LocalDate billing_data_pgto;
	
	@Column(nullable = false)
	private BigDecimal billing_valor_fatura;

	public Integer getBilling_id() {
		return billing_id;
	}

	public void setBilling_id(Integer billing_id) {
		this.billing_id = billing_id;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public LocalDate getBilling_vencimento() {
		return billing_vencimento;
	}

	public void setBilling_vencimento(LocalDate billing_vencimento) {
		this.billing_vencimento = billing_vencimento;
	}

	public String getBilling_status() {
		return billing_status;
	}

	public void setBilling_status(String billing_status) {
		this.billing_status = billing_status;
	}

	public LocalDate getBilling_data_pgto() {
		return billing_data_pgto;
	}

	public void setBilling_data_pgto(LocalDate billing_data_pgto) {
		this.billing_data_pgto = billing_data_pgto;
	}

	public BigDecimal getBilling_valor_fatura() {
		return billing_valor_fatura;
	}

	public void setBilling_valor_fatura(BigDecimal billing_valor_fatura) {
		this.billing_valor_fatura = billing_valor_fatura;
	}
}
