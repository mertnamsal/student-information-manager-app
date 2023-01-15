package com.mertnamsal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OgrenciBilgi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String cinsiyet;
	
	@Column(nullable = false)
	private long tel1;
	
	@Column(nullable = false)
	private String adres1;
	
	@Column(nullable = true)
	private long tel2;
	
	@Column(nullable = true)
	private String adres2;


	public OgrenciBilgi() {
		super();
	}

	public OgrenciBilgi(String cinsiyet, long tel1, String adres1, long tel2, String adres2) {
		super();
		this.cinsiyet = cinsiyet;
		this.tel1 = tel1;
		this.adres1 = adres1;
		this.tel2 = tel2;
		this.adres2 = adres2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	

	public String getAdres1() {
		return adres1;
	}

	public void setAdres1(String adres1) {
		this.adres1 = adres1;
	}


	public String getAdres2() {
		return adres2;
	}

	public void setAdres2(String adres2) {
		this.adres2 = adres2;
	}

	public long getTel1() {
		return tel1;
	}

	public void setTel1(long tel1) {
		this.tel1 = tel1;
	}

	public long getTel2() {
		return tel2;
	}

	public void setTel2(long tel2) {
		this.tel2 = tel2;
	}
	
	
	
	

	
	
	
	
	
	
}
