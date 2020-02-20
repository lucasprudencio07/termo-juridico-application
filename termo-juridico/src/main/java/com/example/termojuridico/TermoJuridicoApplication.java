package com.example.termojuridico;

import com.example.termojuridico.itext7.MainItext7;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class TermoJuridicoApplication {

	public static void main(String[] args) throws IOException{
		ConfigurableApplicationContext context = SpringApplication.run(TermoJuridicoApplication.class, args);

		MainItext7.main();

		context.close();

	}

}
