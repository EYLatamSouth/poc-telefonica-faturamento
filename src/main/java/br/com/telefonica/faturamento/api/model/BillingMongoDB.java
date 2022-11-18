package br.com.telefonica.faturamento.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BillingMongoDB {

	private String billing_id;
	private String customer_id;
	private String billing_vencimento;
	private String billing_status;
	private String billing_data_pgto;
	private String billing_valor_fatura;
	private String __deleted;
	
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
	public String get__deleted() {
		return __deleted;
	}
	public void set__deleted(String __deleted) {
		this.__deleted = __deleted;
	}
}
