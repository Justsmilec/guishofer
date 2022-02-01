package com.company;

public abstract class Shoferi {

	private String emriShoferit,ekipiShoferit;
	private int pozicioniShoferit;

	//konstruktori klases Shoferi
	Shoferi(String emriShoferit,int pozicioniShoferit,String ekipiShoferit){
		this.emriShoferit = emriShoferit;
		this.pozicioniShoferit = pozicioniShoferit;
		this.ekipiShoferit = ekipiShoferit;
	}


	//metode abstrakte qe merr si parametra statistika te ndryshme per shoferet
	public abstract void statistika(int SaHereVendi1, int SaHereVendi2, int SaHereVendi3, int numriPikeveShoferit,int nrGaraveNeSezon);
}

