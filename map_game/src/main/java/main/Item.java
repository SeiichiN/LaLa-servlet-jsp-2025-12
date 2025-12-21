package main;

public abstract class Item {
	private String name;
	private char suffix;
	
	public Item(char suffix, String name) {
		this.suffix = suffix;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public char getSuffix() {
		return suffix;
	}
}
