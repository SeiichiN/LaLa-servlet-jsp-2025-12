package tools;

public class BrowserOutput implements Output {
	private StringBuilder sb = new StringBuilder();
	
	@Override
	public void print(String s) {
		sb.append(s);
	}
	
	public String toString() {
		return sb.toString();
	}
	
	public void clear() {
		sb = new StringBuilder();
	}
}
