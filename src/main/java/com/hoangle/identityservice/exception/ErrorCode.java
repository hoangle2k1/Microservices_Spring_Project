package com.hoangle.identityservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//Why can't use Setter here
//@Setter
@AllArgsConstructor
//Vì nó là Enum nên nó sử dụng giá trị bằng tên của mình
//-> Bản chất Enum là một lớp static
public enum ErrorCode {
    //Each exception have 1 code
    INVALID_KEY(1001,"Invalid message key"),
    USER_EXISTED(1002,"User existed"),
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error"),
    USERNAME_INVALID(1003,"Username must be at least 6 character"),
    INVALID_PASSWORD(1004,"Password must be at least 6 character"),
    USER_NOT_EXISTED(1005,"User not existed")
    ;

    private int code;
    private String message;

}
