package net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CategoryListActivity;

import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Category;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.base.MvpView;

import java.util.List;

/**
 * Created by hsmnzaydn on 6/14/18.
 */

public interface CategoryListActivityMvpView  extends MvpView{

    void loadDataToRecyclerview(List<Category> listOfCategory);
}
