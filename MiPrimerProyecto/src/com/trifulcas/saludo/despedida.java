package com.trifulcas.saludo;

import java.sql.Connection;
import java.sql.DriverManager;

public class despedida {

	public static void main(String[] args) {
		try {
		if (tryConnection()) {
			System.out.println("OK");
		} else {
			System.out.println("KO");
		}
		} catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
	}
	public static boolean tryConnection() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?"
                    + "user=root&password=&serverTimezone=UTC");
        boolean isValid = connection.isValid(2);
        return isValid;
    }
}
