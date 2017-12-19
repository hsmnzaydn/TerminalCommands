package hsmnzaydn.serkanozaydin.net.view.activity.category;

import android.app.Activity;
import android.view.View;

import hsmnzaydn.serkanozaydin.net.model.Category;

import java.util.List;

/**
 * Created by hsmnzaydn on 05.12.2017.
 */

public class CategoryActivityPresenterImp implements CategoryActivityPresenter{

    private CategoryActivityInteractor model;
    private CategoryActivityView view;
    private Activity activity;

    public CategoryActivityPresenterImp(Activity activity,CategoryActivityInteractor model, CategoryActivityView view) {
        this.model = model;
        this.view = view;
        this.activity=activity;
    }

    @Override
    public void onConfiguration() {
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

    @Override
    public void onOpenPopup( View view) {
        model.openSaveCommandPopup(activity,view);
    }
}
