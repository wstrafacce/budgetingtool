package br.com.budgetingtool.api;

public class ResponseModel {
	private String code;
	private String message;
	
	public static final ResponseModel SUCCESS = new ResponseModel("0", "success");
	public static final ResponseModel TOKEN_ERROR = new ResponseModel("1", "invalid access token");
	public static final ResponseModel USER_ALREADY_REG_ERROR = new ResponseModel("3", "email already registered");
	public static final ResponseModel UNVALID_CRED_ERROR = new ResponseModel("4", "invalid username or passwd");
	private static final String REQUIRED_FIELD_MSG = "required field: %s";

	public ResponseModel(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public static ResponseModel getRequiredFieldRespError(final String field){
		return new ResponseModel("2", String.format(REQUIRED_FIELD_MSG, field));
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
