package com.geo.easypoint.common.exception;

import com.geo.easypoint.common.exception.dto.ExceptionResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class EasyPointControllerAdvice {


    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ExceptionResponseDto handleNotFoundException(NotFoundException exception) {
        log.error(exception.getMessage(), exception);
        return new ExceptionResponseDto(exception.getMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ExceptionResponseDto handleBadRequestException(BadRequestException exception) {
        log.error(exception.getMessage(), exception);
        return new ExceptionResponseDto(exception.getMessage());
    }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ExceptionResponseDto handleUnexpectedException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ExceptionResponseDto(exception.getMessage());
    }

}
