package com.codecool.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="This email is already in use")
public class UserAlreadyRegisteredException extends Exception{
}
