package br.com.telefonica.faturamento.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Faturamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String billing_id;
	
	@Column(nullable = false)
	private String customer_id;
	
	@Column(nullable = false)
	private String billing_vencimento;
	
	@Column(nullable = false)
	private String billing_status;
	
	@Column(nullable = false)
	private String billing_data_pgto;
	
	@Column(nullable = false)
	private String billing_valor_fatura;

	public String getBilling_id() {
		return billing_id;
	}

	public void setBilling_id(String billing_id) {
		this.billing_id = billing_id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getBilling_vencimento() {
		return billing_vencimento;
	}

	public void setBilling_vencimento(String billing_vencimento) {
		this.billing_vencimento = billing_vencimento;
	}

	public String getBilling_status() {
		return billing_status;
	}

	public void setBilling_status(String billing_status) {
		this.billing_status = billing_status;
	}

	public String getBilling_data_pgto() {
		return billing_data_pgto;
	}

	public void setBilling_data_pgto(String billing_data_pgto) {
		this.billing_data_pgto = billing_data_pgto;
	}

	public String getBilling_valor_fatura() {
		return billing_valor_fatura;
	}

	public void setBilling_valor_fatura(String billing_valor_fatura) {
		this.billing_valor_fatura = billing_valor_fatura;
	}
}
