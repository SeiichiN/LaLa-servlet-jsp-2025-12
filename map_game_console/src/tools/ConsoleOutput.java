package tools;

public class ConsoleOutput implements Output {

	@Override
	public void print(String s) {
		System.out.print(s);
	}
	
	@Override
	public void print(char c) {
		System.out.print(c);
	}
	
	@Override
	public void println(String s) {
		System.out.println(s);
	}

	@Override
	public void println(char c) {
		System.out.println(c);
	}
	
	@Override
	public void println() {
		System.out.println();
	}
}
