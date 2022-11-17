package br.com.telefonica.faturamento.api.model;

import java.math.BigDecimal;
import java.util.Date;

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
	private Integer cobranca_id;
	
	@Column(nullable = false)
	private Integer billing_id;
	
	@Column(nullable = false)
	private Date cobranca_vencimento;
	
	@Column(nullable = false)
	private String cobranca_status;

	@Column(nullable = false)
	private BigDecimal cobranca_valor;

	@Column(nullable = false)
	private Date cobranca_pagamento;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Billing billing;
	
	public Integer getCobranca_id() {
		return cobranca_id;
	}
	
	public void setCobranca_id(Integer cobranca_id) {
		this.cobranca_id = cobranca_id;
	}
	
	public Integer getBilling_id() {
		return billing_id;
	}
	
	public void setBilling_id(Integer billing_id) {
		this.billing_id = billing_id;
	}
	
	public Date getCobranca_vencimento() {
		return cobranca_vencimento;
	}
	
	public void setCobranca_vencimento(Date cobranca_vencimento) {
		this.cobranca_vencimento = cobranca_vencimento;
	}
	
	public String getCobranca_status() {
		return cobranca_status;
	}
	
	public void setCobranca_status(String cobranca_status) {
		this.cobranca_status = cobranca_status;
	}
	
	public BigDecimal getCobranca_valor() {
		return cobranca_valor;
	}
	
	public void setCobranca_valor(BigDecimal cobranca_valor) {
		this.cobranca_valor = cobranca_valor;
	}
	
	public Date getCobranca_pagamento() {
		return cobranca_pagamento;
	}
	
	public void setCobranca_pagamento(Date cobranca_pagamento) {
		this.cobranca_pagamento = cobranca_pagamento;
	}
}
