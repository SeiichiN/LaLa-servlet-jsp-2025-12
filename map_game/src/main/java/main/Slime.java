package main;

import java.util.Random;

import tools.BrowserOutput;
import tools.Output;
import tools.Utility;

public class Slime extends Monster {
	
	public Slime(char suffix, String name, int hp, Output out) {
		super(suffix, name, hp, out);
	}

	public Slime() {
		this('s', "スライム", 100, new BrowserOutput());
	}
	
	public Slime(int hp) {
		this('s', "スライム", hp, new BrowserOutput());
	}

	@Override
	public void attack(Player player) {
		if (this.getHp() <= 0) return;
		Random r = new Random();
		if (r.nextBoolean()) {
			this.getOut().print("\n" + getName() + "は" + player.getName() + "に毒霧攻撃を発動した!");
			int damage = 10 + Utility.RND.nextInt(30);
			player.setHp(player.getHp() - damage); 
			this.getOut().print(player.getName() + "は" + damage + "のダメージを受けた!");
		} else {
			super.attack(player);
		}
	}

	
}
