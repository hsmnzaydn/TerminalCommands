package net.serkanozaydin.terminalcommands.view.activity.category;

/**
 * Created by hsmnzaydn on 05.12.2017.
 */

public interface CategoryActivityView {

    void onShowLoading();
    void onShowError();
    void onDismissLoading();
    void onLoadingDataToList(String language);



}
