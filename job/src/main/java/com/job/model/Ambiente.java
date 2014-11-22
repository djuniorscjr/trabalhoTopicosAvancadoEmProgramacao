package com.job.model;

import java.io.Serializable;

public class Ambiente implements Serializable {
	
	private int qntPessoas;
	private boolean lampada;
	private boolean arCondicionado;
	private float potenciaLampada;
	private float potenciaArCondicionado;
	private float distancia;
	
	
	public boolean isLampada() {
		return lampada;
	}
	public void setLampada(boolean lampada) {
		this.lampada = lampada;
	}
	public boolean isArCondicionado() {
		return arCondicionado;
	}
	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}
	public float getPotenciaLampada() {
		return potenciaLampada;
	}
	public void setPotenciaLampada(float potenciaLampada) {
		this.potenciaLampada = potenciaLampada;
	}
	public float getPotenciaArCondicionado() {
		return potenciaArCondicionado;
	}
	public void setPotenciaArCondicionado(float potenciaArCondicionado) {
		this.potenciaArCondicionado = potenciaArCondicionado;
	}
	public int getQntPessoas() {
		return qntPessoas;
	}
	public void setQntPessoas(int qntPessoas) {
		this.qntPessoas = qntPessoas;
	}
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	
	
	
}
