package businessLogic;

public class Validator {

	public boolean validInput(String email, String password) {
		if(email.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
		return true;
		return false;
	}

}
