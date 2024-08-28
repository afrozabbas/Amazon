package com.thousand.project.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private String message;
    private String details;
    private LocalDateTime timeStamp;

public ErrorResponse(String message,String details){
    this.message=message;
    this.details=details;
    this.timeStamp=LocalDateTime.now();
}

}
