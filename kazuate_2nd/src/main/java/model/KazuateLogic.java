package model;

public class KazuateLogic {
	public void execute(Kazu kazu) {
		int num = kazu.getNum();
		int kotae = kazu.getKotae();
		if (num == kotae) {
			kazu.setResult("正解です");
		} else if (num > kotae) {
			kazu.setResult("大きすぎます");
		} else {
			kazu.setResult("小さすぎます");
		}
	}
}
