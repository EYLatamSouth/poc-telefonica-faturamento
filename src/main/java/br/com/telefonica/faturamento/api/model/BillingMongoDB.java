package br.com.telefonica.faturamento.api.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BillingMongoDB {

	private Integer billing_id;
	private Integer customer_id;
	private Date billing_vencimento;
	private String billing_status;
	private Date billing_data_pgto;
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
	
	public Date getBilling_vencimento() {
		return billing_vencimento;
	}
	
	public void setBilling_vencimento(Date billing_vencimento) {
		this.billing_vencimento = billing_vencimento;
	}
	
	public String getBilling_status() {
		return billing_status;
	}
	
	public void setBilling_status(String billing_status) {
		this.billing_status = billing_status;
	}
	
	public Date getBilling_data_pgto() {
		return billing_data_pgto;
	}
	
	public void setBilling_data_pgto(Date billing_data_pgto) {
		this.billing_data_pgto = billing_data_pgto;
	}
	
	public BigDecimal getBilling_valor_fatura() {
		return billing_valor_fatura;
	}
	
	public void setBilling_valor_fatura(BigDecimal billing_valor_fatura) {
		this.billing_valor_fatura = billing_valor_fatura;
	}
}
