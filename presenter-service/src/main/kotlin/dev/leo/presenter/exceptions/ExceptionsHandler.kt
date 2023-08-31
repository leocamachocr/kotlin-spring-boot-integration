package dev.leo.presenter.exceptions

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

val logger: Logger = LoggerFactory.getLogger(ExceptionResponseHandler::class.java)

@ControllerAdvice
class ExceptionResponseHandler {
    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(ex.message, ex.errorCode.code)
        val result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
        logger.error(ex.message)
        return result
    }


    @ExceptionHandler(Throwable::class)
    fun handleOther(ex: Throwable): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(ErrorCode.UNKNOWN_ERROR.message, ErrorCode.UNKNOWN_ERROR.code)
        val result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
        logger.error(ex.message)
        return result
    }

}