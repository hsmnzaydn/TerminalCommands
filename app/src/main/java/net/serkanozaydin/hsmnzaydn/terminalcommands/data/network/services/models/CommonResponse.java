package net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models;

/**
 * Created by hsmnzaydn on 12.01.2018.
 */

public class CommonResponse {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
