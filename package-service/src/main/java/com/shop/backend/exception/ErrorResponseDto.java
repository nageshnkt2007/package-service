package com.shop.backend.exception;

public class ErrorResponseDto {

    private Integer requestStatus;
    private String error;
    private String errorMessage;

    public ErrorResponseDto(Integer requestStatus,
                            String error,
                            String errorMessage) {
        this.requestStatus = requestStatus;
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public Integer getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Integer requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
