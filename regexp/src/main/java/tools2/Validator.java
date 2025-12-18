package tools2;

import java.util.regex.Pattern;

public class Validator {
	public static final Pattern ID_PATTERN =
            Pattern.compile("^[0-9a-zA-Z]{4}$");
	
	private Validator() {}
	
	public static boolean validateId(String id) {
		return ID_PATTERN.matcher(id).matches();
	}
}
