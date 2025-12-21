package main;

public class Potion extends Item {
	private int recoveryHp = 100;
	
	public Potion() {
		this('p', "ポーション");
	}
	
	public Potion(char suffix, String name) {
		super(suffix, name);
	}

	public int getRecoveryHp() {
		return recoveryHp;
	}

}
