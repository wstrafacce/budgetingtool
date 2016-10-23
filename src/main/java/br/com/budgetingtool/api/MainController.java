package br.com.budgetingtool.api;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.budgetingtool.model.OperationTest;
import br.com.budgetingtool.model.PizzaChart;
import br.com.grow.budgetingtool.bo.IUserBO;
import br.com.grow.budgetingtool.model.enuns.StatusEnum;
import br.com.grow.budgetingtool.vo.OperationVO;
import br.com.grow.budgetingtool.vo.UserVO;

@RestController
public class MainController {
	private SecureRandom random = new SecureRandom();
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";

	@Autowired
	private IUserBO userBO;

	/**
	 * register user
	 * 
	 * @param payload
	 *            containing user data
	 * @return responseModel with success or error data
	 */
	@RequestMapping("/registerUser")
	public @ResponseBody ResponseModel registerUser(@RequestBody final Map<String, Object> payload) {
		System.out.println(payload);
		final String username = (String) payload.get(EMAIL);
		final String password = (String) payload.get(PASSWORD);

		if (username == null || username.isEmpty()) {
			return ResponseModel.getRequiredFieldRespError(EMAIL);
		}
		if (password == null || password.isEmpty()) {
			return ResponseModel.getRequiredFieldRespError(PASSWORD);
		}
		final boolean isEmailAlreadyReg = this.userBO.findUserByEmail(username).getRefClassInstance() != null;
		if (isEmailAlreadyReg) {
			System.out.println(payload);
			return ResponseModel.USER_ALREADY_REG_ERROR;
		}

		UserVO user;
		try {
			user = new UserVO();
			user.setEmail(username);
			user.setPassword(password);
			user.setLastname((String) payload.get(LAST_NAME));
			user.setName((String) payload.get(LAST_NAME));
			user.setStatus(StatusEnum.INACTIVE);

			userBO.createUser(user);
			return ResponseModel.SUCCESS;
		} catch (Exception e) {
			return new ResponseModel("5", e.getMessage());
		}
	}

	@RequestMapping("/permDenied")
	public @ResponseBody ResponseModel permissionDenied() {
		return ResponseModel.TOKEN_ERROR;
	}

	/**
	 * update existing user
	 * 
	 * @param payload
	 *            containing user data
	 * @return responseModel with result of operation.
	 */
	@RequestMapping("/api/updateUser")
	public @ResponseBody ResponseModel updateUser(@RequestBody final Map<String, Object> payload) {
		final String username = (String) payload.get(EMAIL);

		if (username == null || username.isEmpty()) {
			return ResponseModel.getRequiredFieldRespError(EMAIL);
		}

		final String password = (String) payload.get(PASSWORD);
		final String firstName = (String) payload.get(FIRST_NAME);
		final String lastName = (String) payload.get(LAST_NAME);

		// final User user = new User();
		// user.setUsername(username);

		System.out.println("populate and update user");

		return ResponseModel.SUCCESS;
	}

	/**
	 * login operation
	 * 
	 * @return if success, response will be sent with auth token.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseModel login(@RequestBody final Map<String, Object> payload, HttpServletResponse response) {
		final String username = (String) payload.get(EMAIL);
		final String password = (String) payload.get(PASSWORD);

		if (username == null || username.isEmpty()) {
			return ResponseModel.getRequiredFieldRespError(EMAIL);
		}
		if (password == null || password.isEmpty()) {
			return ResponseModel.getRequiredFieldRespError(PASSWORD);
		}

		final Boolean isValidCred = true;// TODO XXX change to business
		if (isValidCred) {
			final String authToken = new BigInteger(130, random).toString(32);
			response.setHeader(AuthFilterImpl.XAUTH, authToken);
			// TODO XXX register authToken
			return ResponseModel.SUCCESS;
		} else {
			return ResponseModel.UNVALID_CRED_ERROR;
		}
	}

	@RequestMapping(value = "/api/getExpensesPizzaChart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PizzaChart getIncomesChartByUser() {
		final List<Double> values = new ArrayList<Double>();
		final List<String> categories = new ArrayList<String>();
		return new PizzaChart(values, categories);
	}

	/**
	 * for react test
	 * 
	 * @return list of users
	 */
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserVO> getUsersTest() {
		// final User user = new User("1","Bart", "Simpson",
		// "bartsimpson@movie.com", "ph89Bv67vgV78");
		// final User user2 = new User("2","Homer", "Simpson",
		// "homersimpson@movie.com", "ph89Bv67vgV78");
		// final List<User> results = new ArrayList<User>();
		// results.add(user);
		// results.add(user2);
		return null;
	}

	/**
	 * for react test
	 * 
	 * @return one user instance
	 */
	@RequestMapping(value = "/getExpensesPizzaChart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PizzaChart getIncomesChartTest() {
		final List<Double> values = new ArrayList<Double>();
		values.add(100.0);
		values.add(19.99);
		values.add(75.05);
		final List<String> categories = new ArrayList<String>();
		categories.add("Movies");
		categories.add("Gas");
		categories.add("Mobile");
		return new PizzaChart(values, categories);
	}

	/**
	 * for react test
	 * 
	 * @return one user instance
	 */
	@RequestMapping(value = "/getOperations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OperationTest> getOperationsTest() {
		final List<OperationTest> operations = new ArrayList<OperationTest>();
		OperationTest operation;
		operation = new OperationTest();
		operation.setDescription("Awesome trip");
		operation.setDate("Oct 23 2016");
		operation.setCategory("Gas/Transport");
		operation.setValue(25.46f);
		
		operations.add(operation);

		return operations;
	}

}