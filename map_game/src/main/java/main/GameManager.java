package main;

import java.io.Serializable;

import tools.BrowserOutput;
import tools.Factory;
import tools.Input;
import tools.Output;
import tools.Utility;

public class GameManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ysize;
	private int xsize;
	private char[][] map;
	private int numMonsters = 0;
	private boolean isEnd = false;
	private int defeatedMonsters = 0;
	private Output out;
	private Input in;
	
	public GameManager() { }
	
	public GameManager(int ysize, int xsize, Output out, Input in) {
		this.out = out;
		this.in = in;
		this.ysize = ysize;
		this.xsize = xsize;
		this.map = new char[ysize][xsize];
		initMap();
	}
	
	private void initMap() {
		for (int y = 0; y < ysize; y++) {
			for (int x = 0; x < xsize; x++) {
				map[y][x] = '.';
			}
		}
	}

	public int getYsize() {
		return ysize;
	}

	public int getXsize() {
		return xsize;
	}
	
	public char[][] getMap() {
		return map;
	}
	
	private void setPosition(char ch) {
		int y, x;
		do {
			y = Utility.RND.nextInt(ysize);
			x = Utility.RND.nextInt(xsize);
		} while(map[y][x] != '.');
		map[y][x] = ch;
	}
	
	public void setMonster(char ch) {
		setPosition(ch);
		numMonsters++;
	}
	
	public void setItem(char ch) {
		this.setPosition(ch);
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public Output getOut() {
		return out;
	}

	public int getNumMonsters() {
		return numMonsters;
	}

	public void setNumMonsters(int numMonsters) {
		this.numMonsters = numMonsters;
	}

	public void battle(Player p) {
		char ch = this.map[p.getPy()][p.getPx()];
		Monster m = Factory.createMonster(ch);
		if (m == null) return;
		out.print(m.getName() + "が現れた！");
		while (m.getHp() > 0 && p.getHp() > 0) {
			char ch2 = this.getIn().nextChar("a:攻撃 e:逃げる > ");
			if (ch2 == 'a') {
				attackAndReturn(p, m);
			} else if (ch2 == 'e') {
				out.print(p.getName() + "は逃げた!");
				break;
			}
			battleInfo(p, m);
		}	
	}

	public void attackAndReturn(Player p, Monster m) {
		p.attack(m);
		if (m.getHp() <= 0) {
			out.print(p.getName() + "は" + m.getName() + "を倒した!");
			this.defeatedMonsters++;
			this.map[p.getPy()][p.getPx()] = '.';
		} else {
			m.attack(p);
			if (p.getHp() <= 0) {
				out.print(m.getName() + "は" + p.getName() + "を倒した!");
				isEnd = true;
			}
		}
	}

	public void battleInfo(Player p, Monster m) {
		out.print( p.getName() + " HP:" + p.getHp() + " " + m.getName() + " HP:" + m.getHp());
	}

	public Input getIn() {
		return in;
	}

}
