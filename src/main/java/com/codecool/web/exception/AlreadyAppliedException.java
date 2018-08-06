package com.codecool.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "You are already applied for this advertisement")
public class AlreadyAppliedException extends Exception {
}
