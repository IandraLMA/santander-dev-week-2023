package me.dio.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GeralErrorDTO {


    private Integer errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;


    public GeralErrorDTO(Integer errorCode, String errorMessage,  LocalDateTime timestamp) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }




    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }



    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
