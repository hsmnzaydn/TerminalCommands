package net.serkanozaydin.terminalcommands.view.activity.category;

import android.app.Activity;

import net.serkanozaydin.terminalcommands.model.Category;
import net.serkanozaydin.terminalcommands.utility.Constant;

import java.util.List;

import butterknife.internal.Utils;

/**
 * Created by hsmnzaydn on 05.12.2017.
 */

public class CategoryActivityPresenterImp implements CategoryActivityPresenter{

    private CategoryActivityInteractor model;
    private CategoryActivityView view;

    public CategoryActivityPresenterImp(CategoryActivityInteractor model, CategoryActivityView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onConfiguration(final Activity activity) {
        view.onShowLoading();
        model.languageConfiguration(activity, new CategoryActivityInteractor.LoadDataListener() {

            @Override
            public void onTurkish(List<Category> categoryList) {
                view.onLoadingDataToList(categoryList);
                view.onDismissLoading();
            }

            @Override
            public void onEnglish(List<Category> categoryList) {
                view.onLoadingDataToList(categoryList);
                view.onDismissLoading();
            }

            @Override
            public void onFail() {

                view.onShowError();
                view.onDismissLoading();

            }
        });

    }
}
