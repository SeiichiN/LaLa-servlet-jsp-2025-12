package main;

import tools.BrowserOutput;
import tools.Output;

public class Goblin extends Monster {
	
	public Goblin(char suffix, String name, int hp, Output out) {
		super(suffix, name, hp, out);
	}

	public Goblin() {
		this('g', "ゴブリン", 100, new BrowserOutput());
	}
	
	public Goblin(int hp) {
		this('g', "ゴブリン", hp, new BrowserOutput());
	}
	
}
