package com.example.termojuridico;

import com.example.termojuridico.itext7.MainItext7;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class TermoJuridicoApplication {

	public static void main(String[] args) throws IOException{
		SpringApplication.run(TermoJuridicoApplication.class, args);
//		CreatePdfDocument document = new CreatePdfDocument();
//		document.main();

		MainItext7 mainclass = new MainItext7();


	}

}
