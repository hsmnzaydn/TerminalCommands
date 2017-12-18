package net.serkanozaydin.terminalcommands.view.activity.createpdf;

import net.serkanozaydin.terminalcommands.model.Category;

import java.util.List;

/**
 * Created by hsmnzaydn on 18.12.2017.
 */

public interface CreatePdfActivityView {
    void onShowProgress();
    void onDismissProgress();
    void onDataToList(List<Category> categoryList);
    void onShowError(String error);
    void onShowEmpty(String title);
}
