package main;

public class Ether extends Item {
	private int recoveryMp = 50;
	
	public Ether() {
		this('e', "エーテル");
	}
	
	public Ether(char suffix, String name) {
		super(suffix, name);
	}

	public int getRecoveryMp() {
		return recoveryMp;
	}

}
