package com.example.termojuridico;


public class FalhaDeDelecaoException extends Exception {

   private String message = "Falha ao deletar arquivo!";

   public String getMessage(){
       return this.message;
   }


}
