package com.job.model;

import java.io.Serializable;

public class Ambiente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int qntPessoas;
	private boolean lampada;
	private boolean arCondicionado;
	private float potenciaLampada;
	private float potenciaArCondicionado;
	private float distancia;
	private String observacao;
	
	
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
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
