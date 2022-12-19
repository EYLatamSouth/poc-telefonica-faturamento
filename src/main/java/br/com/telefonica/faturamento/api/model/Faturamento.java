package br.com.telefonica.faturamento.api.model;

import org.apache.camel.language.simple.Simple;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="BILLING")
public class Faturamento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billing_id;
	
	@Column(nullable = false)
	private Integer customer_id;
	
	@Column(nullable = false)
	private String billing_vencimento;
	
	@Column(nullable = false)
	private String billing_status;
	
	@Column(nullable = false)
	private String billing_data_pgto;
	
	@Column(nullable = false)
	private String billing_valor_fatura;

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
