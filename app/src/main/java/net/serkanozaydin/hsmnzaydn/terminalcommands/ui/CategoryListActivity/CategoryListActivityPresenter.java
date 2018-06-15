package net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CategoryListActivity;

import android.app.Activity;

import net.serkanozaydin.hsmnzaydn.terminalcommands.data.DataManager;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.ServiceCallback;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Category;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.CommonResponse;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.base.BasePresenter;

import java.util.List;

/**
 * Created by hsmnzaydn on 6/14/18.
 */

public class CategoryListActivityPresenter<V extends CategoryListActivityMvpView> extends BasePresenter<V> implements CategoryListActivityMvpPresenter<V> {

    private Activity activity;
    private DataManager dataManager;

    public CategoryListActivityPresenter(Activity activity,DataManager dataManager) {
        super(activity);
        this.activity=activity;
        this.dataManager=dataManager;
    }


    @Override
    public void getCategoryList(String language) {
        getMvpView().showLoading();

        dataManager.getCategories(language, new ServiceCallback<List<Category>>() {
            @Override
            public void onResponse(List<Category> response) {


                getMvpView().loadDataToRecyclerview(response);
                getMvpView().dissmisLoading();
            }

            @Override
            public void onError(String message) {
                getMvpView().showError(message);
                getMvpView().dissmisLoading();
            }
        }, new ServiceCallback<CommonResponse>() {
            @Override
            public void onResponse(CommonResponse response) {
                getMvpView().showError(response.getMessage());
                getMvpView().dissmisLoading();
            }

            @Override
            public void onError(String message) {
                getMvpView().showError(message);
                getMvpView().dissmisLoading();
            }
        });



    }
}
