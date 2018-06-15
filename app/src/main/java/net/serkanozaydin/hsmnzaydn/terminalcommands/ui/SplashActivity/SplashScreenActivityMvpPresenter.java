package net.serkanozaydin.hsmnzaydn.terminalcommands.ui.SplashActivity;

import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CategoryListActivity.CategoryListActivityMvpView;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 6/14/18.
 */

public interface SplashScreenActivityMvpPresenter <V extends SplashScreenActivityMvpView> extends MvpPresenter<V> {
    void openCategoryList();
}
