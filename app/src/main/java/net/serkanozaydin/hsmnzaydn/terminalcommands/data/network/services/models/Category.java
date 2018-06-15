package net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @Expose
    @SerializedName("__v")
    private int __v;
    @Expose
    @SerializedName("_id")
    private String _id;
    @Expose
    @SerializedName("language")
    private String language;
    @Expose
    @SerializedName("title")
    private String title;

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
