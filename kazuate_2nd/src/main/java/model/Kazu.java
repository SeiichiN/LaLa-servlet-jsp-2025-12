package model;

import java.io.Serializable;

public class Kazu implements Serializable {
	private int kotae;
	private int user;
	private String result;
	
	public Kazu () {}
	public Kazu(int kotae, int user) {
		this.kotae = kotae;
		this.user = user;
	}

	public int getKotae() {
		return kotae;
	}

	public void setKotae(int kotae) {
		this.kotae = kotae;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
