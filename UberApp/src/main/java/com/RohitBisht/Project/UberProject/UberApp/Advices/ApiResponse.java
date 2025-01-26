package com.RohitBisht.Project.UberProject.UberApp.Advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class ApiResponse<T> {
    @JsonFormat(pattern = "hh:mm:ss dd:MM:yyyy")
    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;

    public ApiResponse(LocalDateTime timeStamp) {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
