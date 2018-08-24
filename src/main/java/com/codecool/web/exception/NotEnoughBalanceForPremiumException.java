package com.codecool.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="You haven't got enough Golden Hands to upgrade your ad to premium")
public class NotEnoughBalanceForPremiumException extends Exception {
}
