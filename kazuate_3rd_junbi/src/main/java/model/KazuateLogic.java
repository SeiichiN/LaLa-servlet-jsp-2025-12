package model;

public class KazuateLogic {
	public void execute(Kazu kazu) {
		if (kazu.getKotae() == kazu.getUser()) {
			kazu.setResult("正解です");
		} else if (kazu.getKotae() < kazu.getUser()) {
			kazu.setResult("大きすぎます");
		} else {
			kazu.setResult("小さすぎます");
		}
	}
}
