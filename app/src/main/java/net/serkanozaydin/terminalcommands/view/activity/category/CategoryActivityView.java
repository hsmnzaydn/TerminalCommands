package net.serkanozaydin.terminalcommands.view.activity.category;

import net.serkanozaydin.terminalcommands.model.Category;

import java.util.List;

/**
 * Created by hsmnzaydn on 05.12.2017.
 */

public interface CategoryActivityView {

    void onShowLoading();
    void onShowError();
    void onDismissLoading();
    void onLoadingDataToList(List<Category> listOfCategory);



}
