package main;

public class GameManager {
	private int ysize;
	private int xsize;
	private char[][] map;
	
	public GameManager(int ysize, int xsize) {
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
}
