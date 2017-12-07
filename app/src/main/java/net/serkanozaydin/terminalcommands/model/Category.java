package net.serkanozaydin.terminalcommands.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hsmnzaydn on 06.12.2017.
 */

public class Category {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("categoryThumbnail")
    @Expose
    private String categoryThumbnail;

    @SerializedName("categoryName")
    @Expose
    private String categoryName;


    @SerializedName("commands")
    @Expose
    private List<Command> commands = null;

    public String getCategoryThumbnail() {
        return categoryThumbnail;
    }

    public void setCategoryThumbnail(String categoryThumbnail) {
        this.categoryThumbnail = categoryThumbnail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}
