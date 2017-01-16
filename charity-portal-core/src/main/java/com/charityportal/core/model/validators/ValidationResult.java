package com.charityportal.core.model.validators;

import java.util.LinkedList;
import java.util.List;

public class ValidationResult {
	
	private boolean valid = true;
	
	private List<ValidationProblem> problems = new LinkedList<>();
	
	public boolean isValid() {
		return valid;
	}

	public void addProblem(ValidationProblem problem) {
		valid = false;
		problems.add(problem);
	}

}
