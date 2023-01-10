package Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

//Flyweight factory. Returns shared flyweight based on key
public class ErrorMessageFactory {

	//This serves as key for getting flyweight instance
	public enum ErrorType {GenericSystemError, PageNotFoundError, ServerError}

	private static final ErrorMessageFactory FACTORY = new ErrorMessageFactory();

	public static ErrorMessageFactory getInstance() {
		return FACTORY;
	}

	private Map<ErrorType, SystemErrorMessage> errorMessage = new HashMap<>();
	private ErrorMessageFactory() {
		errorMessage.put(ErrorType.GenericSystemError,
				new SystemErrorMessage("A generic error of type $errorCode occurred. Please refer to:\n",
						"http://google.com/q="));

		errorMessage.put(ErrorType.PageNotFoundError,
				new SystemErrorMessage("A page not found error of type $errorCode occurred. Please refer to:\n",
						"http://google.com/q="));
	}

	public SystemErrorMessage getError(ErrorType type) {
		return errorMessage.get(type);
	}

	public UserBannedErrorMessage getUserBannedMessage(String caseId) {
		return new UserBannedErrorMessage(caseId);
	}
}
