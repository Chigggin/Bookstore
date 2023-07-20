package Assignment.Bookstore.Exception;

import java.util.Date;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ErrorDetails {

    private final Date timestamp;

    private final int statusCode;

    private final String message;

    public Date getTimestamp() {
        return timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

}