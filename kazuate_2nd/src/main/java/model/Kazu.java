package model;

import java.io.Serializable;

public class Kazu implements Serializable {
	private int kotae;
	private int num;
	private String result;
	
	public Kazu() { }
	
	public int getKotae() {
		return kotae;
	}

	public void setKotae(int kotae) {
		this.kotae = kotae;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
