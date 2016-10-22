package br.com.budgetingtool;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.budgetingtool.model.User;

@RestController
public class RegisterUserController {
	
	@RequestMapping("/registerUser")
    public @ResponseBody User registerUser(@RequestBody final Map<String, Object> payload) {
		//final JSONObject json = new JSONObject(payload);
		final User user = new User();
		user.setUsername((String)payload.get("username"));
        return user;
    }
	
	@RequestMapping(value = "/getUser", method=RequestMethod.GET)
    public @ResponseBody User getUser() {
		final User user = new User("1","Bart", "Simpson", "bartsimpson@movie.com", "ph89Bv67vgV78");
        return user;
    }

}
