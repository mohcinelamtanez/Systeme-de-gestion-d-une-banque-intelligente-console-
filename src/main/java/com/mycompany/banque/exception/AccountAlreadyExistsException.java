package com.mycompany.banque.exception;

/**
 * @author USER
 **/
public class AccountAlreadyExistsException extends RuntimeException{
    public AccountAlreadyExistsException(){ } ;
    public AccountAlreadyExistsException(String message){
        super(message) ;
    }

}
