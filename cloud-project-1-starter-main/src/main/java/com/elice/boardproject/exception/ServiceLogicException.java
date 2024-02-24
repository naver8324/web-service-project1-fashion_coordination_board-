package com.elice.boardproject.exception;

import lombok.Getter;

@Getter
public class ServiceLogicException extends RuntimeException {
    private final ExceptionCode boardExceptionCode;

    public ServiceLogicException(ExceptionCode boardExceptionCode){
        super(boardExceptionCode.getMessage());
        this.boardExceptionCode = boardExceptionCode;
    }
}
