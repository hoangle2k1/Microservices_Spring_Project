package com.hoangle.identityservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//AppException được dùng để xử lý những ngoại lệ phát sinh trong quá trình sử dụng ứng dụng
//Những ngoại lệ này không có sẵn trong java
public class AppException extends  RuntimeException{
    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        //Parent class Constructor
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }


}
