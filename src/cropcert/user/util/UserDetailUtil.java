package cropcert.user.util;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.client.validation.Assertion;

import cropcert.user.user.User;
import cropcert.user.user.UserService;

public class UserDetailUtil {

	public static User getUserDetails(HttpServletRequest request, UserService userService) {
		Assertion assertion = (Assertion) request.getSession().getAttribute("_const_cas_assertion_");
		String email        = assertion.getPrincipal().getName();
		return userService.findByPropertyWithCondtion("email", email, "="); 
	}
}