package br.com.telefonica.faturamento.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BillingMongoDB {

	private Long billing_id;
	private Long customer_id;
	private String billing_vencimento;
	private String billing_status;
	private String billing_data_pgto;
	private Double billing_valor_fatura;
	private Boolean __deleted;

	public void setBilling_id(Long billing_id) {
		this.billing_id = billing_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public void setBilling_vencimento(String billing_vencimento) {
		this.billing_vencimento = billing_vencimento;
	}
	public void setBilling_status(String billing_status) {
		this.billing_status = billing_status;
	}
	public void setBilling_data_pgto(String billing_data_pgto) {
		this.billing_data_pgto = billing_data_pgto;
	}
	public void setBilling_valor_fatura(Double billing_valor_fatura) {
		this.billing_valor_fatura = billing_valor_fatura;
	}
	public void set__deleted(Boolean __deleted) {
		this.__deleted = __deleted;
	}
	public Long getBilling_id() {
		return billing_id;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public String getBilling_vencimento() {
		return billing_vencimento;
	}
	public String getBilling_status() {
		return billing_status;
	}
	public String getBilling_data_pgto() {
		return billing_data_pgto;
	}
	public Double getBilling_valor_fatura() {
		return billing_valor_fatura;
	}
	public Boolean get__deleted() {
		return __deleted;
	}
	
	
}
