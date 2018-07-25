package com.codecool.web.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Wrong verification code entered!")
public class WrongVerificationCodeException extends Exception {
}
