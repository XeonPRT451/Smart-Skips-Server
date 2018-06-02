package cdu.xeon.basic.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {
	
	/** public static void main(String[] args) {



	        try {
				System.out.println(SecurityUtil.md5("admin1","123"));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }**/
	 
	public static String md5(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		return new BigInteger(1,md.digest()).toString(16);
	}
	
	public static String md5(String username,String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(username.getBytes());
		md.update(password.getBytes());
		return new BigInteger(1,md.digest()).toString(16);
	}
}
