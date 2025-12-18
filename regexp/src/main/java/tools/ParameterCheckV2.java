package tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParameterCheckV2 {
	public static final Pattern ID_PATTERN =
            Pattern.compile("^[0-9a-zA-Z]{4}$");
	List<String> errors = new ArrayList<String>();
	
	public List<String> checkId(String id) {
		if (id == null || id.length() == 0) {
			errors.add("IDが入力されていません");
		}
		else if (ID_PATTERN.matcher(id).matches() == false) {
			errors.add("IDが不正です");
		}
		return errors;
	}
}
