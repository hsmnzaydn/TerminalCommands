package net.serkanozaydin.terminalcommands.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hsmnzaydn on 06.12.2017.
 */

@Entity
public class Command {

    @PrimaryKey(autoGenerate = true)
    public int id;



    @ColumnInfo(name = "command_name")
    @SerializedName("CommandName")
    @Expose
    private String commandName;

    @ColumnInfo(name = "command_detail")
    @SerializedName("Detail")
    @Expose
    private String detail;

    public Command(String commandName, String detail) {
        this.commandName = commandName;
        this.detail = detail;
    }

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
