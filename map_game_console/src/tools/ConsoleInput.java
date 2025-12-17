package tools;

import java.util.Scanner;

public class ConsoleInput implements Input {
	private final Scanner sc;
	
	public ConsoleInput(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public int nextInt(String prompt) {
		System.out.print(prompt);
		int num = 0;
		while (true) {
			if (sc.hasNextInt()) {
				num = sc.nextInt();
				break;
			} else {
				System.out.println("数字ではありません");
				sc.next();
			}
		}
		return num;
	}

	@Override
	public char nextChar(String prompt) {
		System.out.print(prompt);
		char ch = ' ';
		while (true) {
			String str = sc.nextLine();
			if (str.length() == 1) {
				ch = str.charAt(0);
				break;
			} else {
				System.out.println("１文字でお願いします");
			}
		}
		return ch;
	}

	@Override
	public String nextLine(String prompt) {
		System.out.print(prompt);
		String s = null;
		while (true) {
			s = sc.nextLine();
			if (s.length() > 0) break;
			System.out.println("入力がありません");
		}
		return s;
	}

}
