package tools;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

import main.GameManager;

public class SettingUtil {
	private final ReadSettings rs = new ReadSettings();
	private final GameManager gm;
	
	public SettingUtil(GameManager gm) {
		this.gm = gm;
	}

	public void execute() {
		printProperties();
		char ch = gm.in.nextChar("変更しますか? (y/n) > ");
		if (ch == 'y') {
			saveProperties();
		}
	}
	
	public void printProperties() {
		gm.out.println("現在の設定");
		gm.out.println("1. マップの行数:" + rs.YSIZE);
		gm.out.println("2. マップの列数:" + rs.XSIZE);
		gm.out.println("3. ゴブリンの数:" + rs.NUM_GOBLIN);
		gm.out.println("4. スライムの数:" + rs.NUM_SLIME);
		gm.out.println("5. ポーションの数:" + rs.NUM_POTION);
		gm.out.println("6. プレイヤーの名前:" + rs.NAME);
	}
	
	public void saveProperties() {
		String ysize = "" + gm.in.nextInt("マップの行数 > ");
		String xsize = "" + gm.in.nextInt("マップの列数 > ");
		String goblin = "" + gm.in.nextInt("コゴブリンの数 > ");
		String slime = "" + gm.in.nextInt("スライムの数 > ");
		String potion = "" + gm.in.nextInt("ポーションの数 > ");
		String name = gm.in.nextLine("プレイヤーの名前 > ");

		Properties prop = new Properties();
		prop.setProperty("ysize", ysize);
		prop.setProperty("xsize", xsize);
		prop.setProperty("goblin", goblin);
		prop.setProperty("slime", slime);
		prop.setProperty("potion", potion);
		prop.setProperty("name", name);
		
		try (Writer writer = new OutputStreamWriter(
				new FileOutputStream("player.properties"), "UTF-8")) {
			prop.store(writer, "Player Settings");
		} catch (Exception e) {
			e.printStackTrace();
		}
		gm.out.println("設定を保存しました");
		
	}

}
