package com.airport.project;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class AiportApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiportApplication.class, args);
	}

    private static String getBase() {
    	try {
	        String path = ".\\datasource.ini";
	        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	            String line = null;
	            line = br.readLine();
	            return line;
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    private static String getUser() {
    	try {
	        String path = ".\\datasource.ini";
	        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	            String line = null;
	            line = br.readLine();
	            line = br.readLine();
	            return line;
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    private static String getPassword() {
    	try {
	        String path = ".\\datasource.ini";
	        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	            String line = null;
	            line = br.readLine();
	            line = br.readLine();
	            line = br.readLine();
	            return line;
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
        
	@Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://"+getBase());
        dataSource.setUsername(getUser());
        dataSource.setPassword(getPassword());
        return dataSource;
    }
}
