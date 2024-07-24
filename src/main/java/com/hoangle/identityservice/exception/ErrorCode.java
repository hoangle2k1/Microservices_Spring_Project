package com.hoangle.identityservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//Why can't use Setter here
//@Setter
@AllArgsConstructor
public enum ErrorCode {
    //Each exception have 1 code
    USER_EXISTED(1001,"User existed"),
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error");

    private int code;
    private String message;

}
