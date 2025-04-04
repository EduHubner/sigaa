package com.classes.Conexao;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {

	final static String NOME_DO_BANCO = "sigaa";
    public static Connection conectar() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" + NOME_DO_BANCO;
            return DriverManager.getConnection(url,"root","EduardoHubner@15062005");
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }
}