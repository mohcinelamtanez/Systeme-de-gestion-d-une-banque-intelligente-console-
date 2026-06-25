package com.mycompany.banque.exception;

/**
 * @author USER
 **/
public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(){};

    public ClientNotFoundException(String message){
        super(message) ;
    }
}
