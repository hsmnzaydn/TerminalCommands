package net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CategoryListActivity;

import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 6/14/18.
 */

public interface CategoryListActivityMvpPresenter <V extends CategoryListActivityMvpView> extends MvpPresenter<V> {

void getCategoryList(String language);
}
