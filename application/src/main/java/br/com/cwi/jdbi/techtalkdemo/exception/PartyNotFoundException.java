package br.com.cwi.jdbi.techtalkdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PartyNotFoundException extends RuntimeException {

    public PartyNotFoundException() {
        super("Party not found");
    }
}
