package tools;

import java.util.Scanner;

public class BrowserInput implements Input {
	private StringBuffer sb = new StringBuffer();
	
	public BrowserInput() {
	}

	@Override
	public void nextChar(String prompt) {
		sb.append(prompt + "<br>");
	}

	public String toString() {
		return sb.toString();
	}
	
	public void clear() {
		sb = new StringBuffer();
	}

}
