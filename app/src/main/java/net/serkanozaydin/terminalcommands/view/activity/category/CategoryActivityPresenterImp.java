package net.serkanozaydin.terminalcommands.view.activity.category;

import android.app.Activity;

import net.serkanozaydin.terminalcommands.utility.Constant;

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
    public void onConfiguration(Activity activity) {
        view.onShowLoading();
        model.languageConfiguration(activity, new CategoryActivityInteractor.LoadDataListener() {
            @Override
            public void onTurkish() {

                view.onLoadingDataToList(Constant.TURKISH);
                view.onDismissLoading();

            }

            @Override
            public void onEnglish() {

                view.onLoadingDataToList(Constant.ENGLISH);
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
