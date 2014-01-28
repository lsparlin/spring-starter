package rename.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import rename.model.RenameMe;

import static org.junit.Assert.*;

public class RenameMeTest {
	
	
	@Test
	public void assert_that_certain_fields_cant_be_null_or_blank() {
		RenameMe renameMe = new RenameMe();
		Map<String, ConstraintViolation<RenameMe>> violationsMap = validate(renameMe);
		assertTrue(violationsMap.get("name").getMessageTemplate().contains("NotEmpty"));
	}

	private <T> Map<String, ConstraintViolation<T>>  validate(T entity) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Map<String, ConstraintViolation<T>> violations = new HashMap<String, ConstraintViolation<T>>();
		for (ConstraintViolation<T> violation : validator.validate(entity)) {
			violations.put(violation.getPropertyPath().toString(), violation);
		}
		return violations;
	}

}
