package com.medipaf.medipaf.ecommerce.handlers;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

// This class has all the attributes that we want to show when the exception is thrown
// In our case, if the exception is thrown, we want to show to the user the message that describe the cause of the exception
// url where exception is thrown and tmeStamp the date when the exception is thrown
@Data
public class ErrorDetails {
    private String message;
    private String url;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY hh:mm:ss")
    private Date timeStamp;
    ErrorDetails(){
        this.timeStamp=new Date();
    }
    ErrorDetails(String message, String url){
        this();
        this.message=message;
        this.url=url;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
