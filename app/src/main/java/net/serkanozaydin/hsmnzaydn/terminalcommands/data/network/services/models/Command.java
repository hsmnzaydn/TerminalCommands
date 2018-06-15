package net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Command {


    @Expose
    @SerializedName("__v")
    private int __v;
    @Expose
    @SerializedName("category")
    private String category;
    @Expose
    @SerializedName("_id")
    private String _id;
    @Expose
    @SerializedName("detail")
    private String detail;
    @Expose
    @SerializedName("text")
    private String text;
    @Expose
    @SerializedName("language")
    private String language;

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
