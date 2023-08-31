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
    fun handleBusinessException(ex: BusinessException): ResponseEntity<ErrorResponse> =
        ErrorResponse(ex.message, ex.errorCode.code)
            .let { ResponseEntity.status(HttpStatus.BAD_REQUEST).body(it) }
            .also { logger.error(ex.message) }


    @ExceptionHandler(Throwable::class)
    fun handleOther(ex: Throwable): ResponseEntity<ErrorResponse> =
        ErrorResponse(ErrorCode.UNKNOWN_ERROR.message, ErrorCode.UNKNOWN_ERROR.code)
            .let { ResponseEntity.status(HttpStatus.BAD_REQUEST).body(it) }
            .also { logger.error(ex.message) }
}