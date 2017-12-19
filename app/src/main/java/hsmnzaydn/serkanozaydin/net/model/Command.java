package hsmnzaydn.serkanozaydin.net.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hsmnzaydn on 06.12.2017.
 */

@Entity
public class Command {

    @PrimaryKey(autoGenerate = true)
    public int id;

    private Boolean isFavourite;

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


    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
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


    public void setFavourite(List<Command> commandList){
        for (Command command:commandList) {
            if(getCommandName().equals(command.getCommandName())){
                setFavourite(true);
            }
        }


    }



}
