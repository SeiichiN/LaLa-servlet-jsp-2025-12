package main;

import tools.ConsoleOutput;
import tools.Output;
import tools.Utility;

public abstract class Monster {
	public String name;
	public int hp;
	public char suffix;
	private Output out;
	
	public Monster(char suffix, String name, int hp) {
		this.name = name;
		this.suffix = suffix;
		this.hp = hp;
		this.out = new ConsoleOutput();
	}
	
	public void attack(Player player) {
		if (this.hp <= 0) return;
		out.println("\n" + name + "は" + player.name + "を攻撃した!");
		int damage = Utility.RND.nextInt(30);
		player.hp -= damage;
		out.println(player.name + "は" + damage + "のダメージを受けた!");
	}
}
