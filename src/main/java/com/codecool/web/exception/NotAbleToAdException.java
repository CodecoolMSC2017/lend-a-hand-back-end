package com.codecool.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Profile must be completed first")
public class NotAbleToAdException extends Exception {
}
