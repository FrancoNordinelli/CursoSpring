package mx.com.gm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPasword {
	public static void main(String[] args) {
		var password = "123";
		System.out.println("PASSWORD: "+ password);
		System.out.println("PASSWORD ENCRIPTADO: "+ enctriptarPassword(password));
	}
	
	public static String enctriptarPassword(String pass) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(pass);
	}
}
