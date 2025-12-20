package main;

import tools.Output;
import tools.Utility;

public abstract class Monster {
	private String name;
	private int hp;
	private char suffix;
	private Output out;
	
	public Monster(char suffix, String name, int hp, Output out) {
		this.name = name;
		this.suffix = suffix;
		this.hp = hp;
		this.out = out;
	}
	
	public void attack(Player player) {
		if (this.hp <= 0) return;
		out.print("\n" + name + "は" + player.getName() + name + "を攻撃した!");
		int damage = Utility.RND.nextInt(30);
		player.setHp(player.getHp() - damage); 
		out.print(player.getName() + "は" + damage + "のダメージを受けた!");
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public char getSuffix() {
		return suffix;
	}

	public Output getOut() {
		return out;
	}
}
