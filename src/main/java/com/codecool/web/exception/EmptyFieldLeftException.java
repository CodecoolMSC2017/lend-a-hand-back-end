package com.codecool.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="Field(s) are left empty")
public class EmptyFieldLeftException extends Exception {
}
