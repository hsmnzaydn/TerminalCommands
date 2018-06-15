package net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CommandListActivity;

import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CategoryListActivity.CategoryListActivityMvpView;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.base.MvpPresenter;

/**
 * Created by hsmnzaydn on 6/15/18.
 */

public interface CommandListActivityMvpPresenter <V extends CommandListActivityMvpView> extends MvpPresenter<V> {

    void getCommands(String categoryId);

}
