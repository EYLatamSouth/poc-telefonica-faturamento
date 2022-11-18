package br.com.telefonica.faturamento.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cobranca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cobranca_id;
	
	@Column(nullable = false)
	private String billing_id;
	
	@Column(nullable = false)
	private String cobranca_vencimento;
	
	@Column(nullable = false)
	private String cobranca_status;

	@Column(nullable = false)
	private String cobranca_valor;

	@Column(nullable = false)
	private String cobranca_pagamento;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Faturamento billing;

	public String getCobranca_id() {
		return cobranca_id;
	}

	public void setCobranca_id(String cobranca_id) {
		this.cobranca_id = cobranca_id;
	}

	public String getBilling_id() {
		return billing_id;
	}

	public void setBilling_id(String billing_id) {
		this.billing_id = billing_id;
	}

	public String getCobranca_vencimento() {
		return cobranca_vencimento;
	}

	public void setCobranca_vencimento(String cobranca_vencimento) {
		this.cobranca_vencimento = cobranca_vencimento;
	}

	public String getCobranca_status() {
		return cobranca_status;
	}

	public void setCobranca_status(String cobranca_status) {
		this.cobranca_status = cobranca_status;
	}

	public String getCobranca_valor() {
		return cobranca_valor;
	}

	public void setCobranca_valor(String cobranca_valor) {
		this.cobranca_valor = cobranca_valor;
	}

	public String getCobranca_pagamento() {
		return cobranca_pagamento;
	}

	public void setCobranca_pagamento(String cobranca_pagamento) {
		this.cobranca_pagamento = cobranca_pagamento;
	}

	public Faturamento getBilling() {
		return billing;
	}

	public void setBilling(Faturamento billing) {
		this.billing = billing;
	}
}
