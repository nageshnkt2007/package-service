package com.shop.backend.exception;

import com.shop.backend.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Package Controller Advice handles Application Exception
 * And Returns ErrorResponseDto which serves as an abstraction from
 * other applications using our API .
 */
@RestControllerAdvice
public class PackageControllerAdvice {

    /**
     * @param exception .
     * @return Custom Response Entity hiding the error .
     */
    @ExceptionHandler(PackageServiceException.class)
    public ResponseEntity<ErrorResponseDto> handlePackageServiceException(PackageServiceException exception) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value()
                , HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() , exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
    }

    /**
     * @param exception for IllegalStateException when we call .get method
     *                  for optional object .
     * @return Custom Response Entity hiding the error .
     */
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponseDto> handleApplicationException(IllegalStateException exception) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(HttpStatus.NO_CONTENT.value()
                , HttpStatus.NO_CONTENT.getReasonPhrase(), Constants.ERROR_MESSAGE_DATA_NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorResponseDto);
    }
    /**
     * @param exception .
     * @return Custom Response Entity hiding the error .
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleApplicationException(Exception exception) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value()
                , HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), Constants.ERROR_MESSAGE);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
    }
}
