package com.company;


public class ShoferiFormula1 extends Shoferi{

	private int SaHereVendi1 = 0, SaHereVendi2 = 0, SaHereVendi3 = 0,nrPikeveShoferit = 0, nrGaraveNeSezon = 0;
	private String id;

	private String emriShoferit,ekipiShoferit;
	private int pozicioniShoferit;

	public ShoferiFormula1(String id,String emriShoferit,int pozicioniShoferit,String ekipiShoferit) {
		//thirret konstruktori superklases per te kaluar te dhenat per shoferin
		super(emriShoferit,pozicioniShoferit,ekipiShoferit);
		if(id == null || id.equals(""))
			this.id = Helper.createId();
		else
			this.id = id;
		this.emriShoferit = emriShoferit;
		this.pozicioniShoferit = pozicioniShoferit;
		this.ekipiShoferit = ekipiShoferit;

	}


	//getters and setters methods


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSaHereVendi1() {
		return SaHereVendi1;
	}


	public void setSaHereVendi1(int saHereVendi1) {
		SaHereVendi1 = saHereVendi1;
	}


	public int getSaHereVendi2() {
		return SaHereVendi2;
	}


	public void setSaHereVendi2(int saHereVendi2) {
		SaHereVendi2 = saHereVendi2;
	}


	public int getSaHereVendi3() {
		return SaHereVendi3;
	}


	public void setSaHereVendi3(int saHereVendi3) {
		SaHereVendi3 = saHereVendi3;
	}


	public int getNrPikeveShoferit() {
		return nrPikeveShoferit;
	}


	public void setNrPikeveShoferit(int nrPikeveShoferit) {
		this.nrPikeveShoferit = nrPikeveShoferit;
	}


	public int getNrGaraveNeSezon() {
		return nrGaraveNeSezon;
	}


	public void setNrGaraveNeSezon(int nrGaraveNeSezon) {
		this.nrGaraveNeSezon = nrGaraveNeSezon;
	}


	public String getEmriShoferit() {
		return emriShoferit;
	}


	public void setEmriShoferit(String emriShoferit) {
		this.emriShoferit = emriShoferit;
	}


	public String getEkipiShoferit() {
		return ekipiShoferit;
	}


	public void setEkipiShoferit(String ekipiShoferit) {
		this.ekipiShoferit = ekipiShoferit;
	}


	public int getPozicioniShoferit() {
		return pozicioniShoferit;
	}


	public void setPozicioniShoferit(int pozicioniShoferit) {
		this.pozicioniShoferit = pozicioniShoferit;
	}


	public void statistika(int SaHereVendi1, int SaHereVendi2, int SaHereVendi3, int nrPikeveShoferit,int nrGaraveNeSezon) {
		this.SaHereVendi1 = SaHereVendi1;
		this.SaHereVendi2 = SaHereVendi2;
		this.SaHereVendi3 = SaHereVendi3;
		this.nrPikeveShoferit = nrPikeveShoferit;
		this.nrGaraveNeSezon = nrGaraveNeSezon;
	}


	public void afishimiTabeles() {
		System.out.format("%20s %16s %20s %15d %10d %10d %10d %10d %10d",
				this.getId(),this.getEmriShoferit(), this.getEkipiShoferit(), this.getPozicioniShoferit(), this.getSaHereVendi1(), this.getSaHereVendi2(), this.getSaHereVendi3()
				,this.getNrPikeveShoferit(), this.getNrGaraveNeSezon());
		System.out.println();
	}

}

