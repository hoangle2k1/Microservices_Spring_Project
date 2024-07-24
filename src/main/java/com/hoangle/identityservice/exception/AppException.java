package com.hoangle.identityservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends  RuntimeException{
    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        //Parent class Constructor
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }


}
