package br.com.telefonica.faturamento.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Impressao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String impressao_id;
	
	@Column(nullable = false)
	private String impressao_date;
	
	@Column(nullable = false)
	private String impressao_status;

	public String getImpressao_id() {
		return impressao_id;
	}

	public void setImpressao_id(String impressao_id) {
		this.impressao_id = impressao_id;
	}

	public String getImpressao_date() {
		return impressao_date;
	}

	public void setImpressao_date(String impressao_date) {
		this.impressao_date = impressao_date;
	}

	public String getImpressao_status() {
		return impressao_status;
	}

	public void setImpressao_status(String impressao_status) {
		this.impressao_status = impressao_status;
	}
}
