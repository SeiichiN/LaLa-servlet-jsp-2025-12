package tools2;

import java.util.ArrayList;
import java.util.List;

public class ParameterCheck {
	private List<String> errors = new ArrayList<String>();
	
	public List<String> checkId(String id) {
		if (id == null || id.length() == 0) {
			errors.add("IDが入力されていません");
		}
		if (Validator.validateId(id) == false) {
			errors.add("IDが不正です");
		}
		return errors;
	}
}
