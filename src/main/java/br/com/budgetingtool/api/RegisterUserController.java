package br.com.budgetingtool.api;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.budgetingtool.model.User;

@RestController
public class RegisterUserController {
	private SecureRandom random = new SecureRandom();
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	
	/**
	 * register user
	 * 
	 * @param payload containing user data
	 * @return responseModel with success or error data
	 */
	@RequestMapping("/registerUser")
    public @ResponseBody ResponseModel registerUser(@RequestBody final Map<String, Object> payload) {
		System.out.println(payload);
		final String username = (String) payload.get(USERNAME);
		final String password = (String) payload.get(PASSWORD);
		
		if (username == null || username.isEmpty()) {
			return ResponseModel.getRequiredFieldRespError(USERNAME);
		}
		if (password == null || password.isEmpty()) {
			return ResponseModel.getRequiredFieldRespError(PASSWORD);
		}
		final boolean isEmailAlreadyReg = true;//TODO XXX change to business validation
		if (isEmailAlreadyReg){
			return ResponseModel.USER_ALREADY_REG_ERROR;
		}
		
		final User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		System.out.println("save user and return success "+user.getUsername());
		
		return ResponseModel.SUCCESS;
    }
	
	@RequestMapping("/permDenied")
	public @ResponseBody ResponseModel permissionDenied(){
		return ResponseModel.TOKEN_ERROR;
	}
	
	/**
	 * update existing user
	 * 
	 * @param payload containing user data
	 * @return responseModel with result of operation.
	 */
	@RequestMapping("/api/updateUser")
    public @ResponseBody ResponseModel updateUser(@RequestBody final Map<String, Object> payload) {
		final String username = (String) payload.get(USERNAME);
		
		if (username == null || username.isEmpty()) {
			return ResponseModel.getRequiredFieldRespError(USERNAME);
		}
		
		final String password = (String) payload.get(PASSWORD);
		final String firstName = (String) payload.get(FIRST_NAME);
		final String lastName = (String) payload.get(LAST_NAME);
		
		final User user = new User();
		user.setUsername(username);
		
		System.out.println("populate and update user");
		
        return ResponseModel.SUCCESS;
    }
	
	/**
	 * login operation
	 * 
	 * @return if success, response will be sent with auth token.
	 */
	@RequestMapping(value = "/login", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseModel login(@RequestBody final Map<String, Object> payload, HttpServletResponse response) {
		final String username = (String) payload.get(USERNAME);
		final String password = (String) payload.get(PASSWORD);
		
		if (username == null || username.isEmpty()) {
			return ResponseModel.getRequiredFieldRespError(USERNAME);
		}
		if (password == null || password.isEmpty()) {
			return ResponseModel.getRequiredFieldRespError(PASSWORD);
		}
		
		final Boolean isValidCred = true;//TODO XXX change to business
		if (isValidCred){
			final String authToken = new BigInteger(130, random).toString(32);
			response.setHeader(AuthFilterImpl.XAUTH, authToken);
			//TODO XXX register authToken
			return ResponseModel.SUCCESS;
		} else {
			return ResponseModel.UNVALID_CRED_ERROR;
		}
    }
	
	/**
	 * for react test
	 * 
	 * @return list of users
	 */
	@RequestMapping(value = "/getUsers", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> getUsers() {
		final User user = new User("1","Bart", "Simpson", "bartsimpson@movie.com", "ph89Bv67vgV78");
		final User user2 = new User("2","Homer", "Simpson", "homersimpson@movie.com", "ph89Bv67vgV78");
		final List<User> results = new ArrayList<User>();
		results.add(user);
		results.add(user2);
        return results;
    }
	
	/**
	 * for react test
	 * 
	 * @return one user instance
	 */
	@RequestMapping(value = "/getUser", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User getUser() {
		final User user = new User("3","Lisa", "Simpson", "lisasimpson@movie.com", "235b2j35b");
        return user;
    }

}