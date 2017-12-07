package net.serkanozaydin.terminalcommands.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hsmnzaydn on 06.12.2017.
 */

public class Command {
    @SerializedName("CommandName")
    @Expose
    private String commandName;
    @SerializedName("Detail")
    @Expose
    private String detail;

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
