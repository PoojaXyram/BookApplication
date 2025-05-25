package com.enterprise.bookapplication.dto;

public class ApiResponse {

  String message;
  boolean Status;

  public ApiResponse(String message, boolean status) {
    this.message = message;
    Status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isStatus() {
    return Status;
  }

  public void setStatus(boolean status) {
    Status = status;
  }
}
