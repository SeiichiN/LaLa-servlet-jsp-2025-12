package main;

import java.util.ArrayList;
import java.util.List;

import tools.Factory;
import tools.Utility;

public class Player {
	private String name = "プレイヤー";
	private int py;
	private int px;
	private final int MAX_HP;
	private int hp;
	private final int HP_RECOVERY_PER_MOVE;
	private final GameManager gm;
	private List<Item> items = new ArrayList<>();
	
	
	public Player(String name, GameManager gm) {
		this.name = name;
		this.gm = gm;
		this.MAX_HP = 100;
		this.hp = this.MAX_HP;
		this.HP_RECOVERY_PER_MOVE = 2;
		setRandomPos();
	}
	
	private void setRandomPos() {
		py = Utility.RND.nextInt(gm.getYsize());
		px = Utility.RND.nextInt(gm.getXsize());
	}
	
	public void command() {
		char ch = gm.in.nextChar("wsad:移動 b:戦う t:取る u:使う i:情報 q:終了 > ");
		switch (ch) {
			case 'w' -> moveUp();
			case 's' -> moveDown();
			case 'a' -> moveLeft();
			case 'd' -> moveRight();
			case 'b' -> gm.battle(this);
			case 't' -> this.take();
			case 'u' -> this.use();
			case 'i' -> this.printInfo();
			case 'q' -> this.setEndTrue();
		}
	}
	
	private void hpRecoveryUp() {
		hp = Math.min(MAX_HP, hp + HP_RECOVERY_PER_MOVE);
	}
	
	public void moveUp() {
		py = Math.max(0, py - 1);
		hpRecoveryUp();
	}
	
	public void moveDown() {
		py = Math.min(gm.getYsize() - 1, py + 1);
		hpRecoveryUp();
	}
	
	public void moveLeft() {
		px = Math.max(0, px - 1);
		hpRecoveryUp();
	}
	
	public void moveRight() {
		px = Math.min(gm.getXsize() - 1, px + 1);
		hpRecoveryUp();
	}
	
	public void setEndTrue() {
		this.gm.setEnd(true);
	}
	
	public void printInfo() {
		gm.getOut().print("HP:" + this.hp + "/" + this.MAX_HP);
		printItems();
	}
	
	public void attack(Monster m) {
		if (this.hp <= 0) return;
		gm.getOut().print("\n" + name + "は" + m.name + "を攻撃した!");
		int damage = Utility.RND.nextInt(30);
		m.hp -= damage;
		gm.getOut().print(m.name + "は" + damage + "のダメージを受けた!");
	}
	
	public void look() {
		char ch = gm.getMap()[py][px];
		String msg = switch(ch) {
		case 'g' -> "ゴブリンが現れた！";
		case 's' -> "スライムが現れた！";
		case 'p' -> "ポーションがあった！";
		case 'e' -> "エーテルがあった！";
		default -> "何も見当たらない";
		};
		gm.getOut().print(msg);
	}
	
	public void take() {
		char ch = gm.getMap()[py][px];
		Item item = Factory.createItem(ch);
		if (item == null) return;
		gm.getOut().print(this.name + "は" + item.name + "を手に入れた!");
		this.items.add(item);
		gm.getMap()[py][px] = '.';
	}
	
	public void printItems() {
		gm.getOut().print("持ち物: ");
		if (items.size() == 0) {
			gm.getOut().print("なし");
			return;
		}
		for (int i = 0; i < items.size(); i++) {
			gm.getOut().print(i + 1 + ":" + items.get(i).name + " ");
		}
		
	}
	
	public Item selectItem() {
		printItems();
		int index = 0;
		while (true) {
			char ch = gm.in.nextChar("選択>");
			index = ch - '0';
			if (index >= 1 && index <= items.size()) break;			
		}
		Item item = items.get(index - 1);
		return item;
	}
	
	public void usePotion(Item item) {
		int nowHP = this.hp;
		if (item instanceof Potion) {
			Potion p = (Potion) item;
			this.hp = Math.min(this.hp + p.recoveryHp, this.MAX_HP);
			gm.getOut().print("HPが" + (this.hp - nowHP) + "回復した!");
			items.remove(item);
		}
	}
	
	public void use() {
		if (this.items.size() == 0) {
			gm.getOut().print("持ち物がありません");
			return;
		}
		Item item = selectItem();
		gm.getOut().print(this.name + "は" + item.name + "を使った!");
		switch (item.suffix) {
		case 'p' -> usePotion(item);
		}
	}

	public int getPy() {
		return py;
	}

	public void setPy(int py) {
		this.py = py;
	}

	public int getPx() {
		return px;
	}

	public void setPx(int px) {
		this.px = px;
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

	public GameManager getGm() {
		return gm;
	}

	public List<Item> getItems() {
		return items;
	}
	
}
