package br.com.telefonica.faturamento.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Impressao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer impressao_id;
	
	@Column(nullable = false)
	private Date impressao_date;
	
	@Column(nullable = false)
	private String impressao_status;

	public Integer getImpressao_id() {
		return impressao_id;
	}

	public void setImpressao_id(Integer impressao_id) {
		this.impressao_id = impressao_id;
	}

	public Date getImpressao_date() {
		return impressao_date;
	}

	public void setImpressao_date(Date impressao_date) {
		this.impressao_date = impressao_date;
	}

	public String getImpressao_status() {
		return impressao_status;
	}

	public void setImpressao_status(String impressao_status) {
		this.impressao_status = impressao_status;
	}
}
