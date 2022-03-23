// code adapted from https://stackoverflow.com/questions/50185655/login-on-java-based-from-txt-file


import java.io.BufferedReader;
import java.io.FileReader;

public class Login {
	
/**
 * 
 * @param username
 * @param password
 * Stored in a separate text file called "users.txt"
 * @return
 */
	    public static boolean login(String username, String password) {
	        try {
	            String txtFile = "users.txt";

	            FileReader fr = new FileReader(txtFile);
	            BufferedReader br = new BufferedReader(fr);
	            String line, user, pass;
	            boolean isLoginSuccess = false;
	            while ((line = br.readLine()) != null) {
	                user = line.split(" ")[0].toLowerCase();
	                pass = line.split(" ")[1].toLowerCase();
	                if (user.equals(username) && pass.equals(password)) {
	                    isLoginSuccess = true;
	                    fr.close();
	                    br.close();
	                    return true;
	                } 
	            }
	            if (!isLoginSuccess) {
	                System.out.println("Login failed. Try again");
	                fr.close();
	                br.close();
	                return false;
	            }
	            fr.close();
	            br.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	        return false;
	}

}
