package hsmnzaydn.serkanozaydin.net.view.activity.createpdf;

import android.app.Activity;

import hsmnzaydn.serkanozaydin.net.EventBus.CategoryListEvent;
import hsmnzaydn.serkanozaydin.net.model.Category;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by hsmnzaydn on 18.12.2017.
 */

public class CreatePdfActivityPresenterImp implements CreatePdfActivityPresenter {
    private CreatePdfActivityInteractor model;
    private CreatePdfActivityView view;
    private Activity activity;

    public CreatePdfActivityPresenterImp(CreatePdfActivityInteractor model, CreatePdfActivityView view, Activity activity) {
        this.model = model;
        this.view = view;
        this.activity = activity;
    }


    @Override
    public void onSuccessConfiguration() {
        view.onShowProgress();
        model.onGetDataFromJson(activity, new CreatePdfActivityInteractor.ListenerGetDataFromJson() {
            @Override
            public void onSuccessGetData(List<Category> commandList) {
                view.onDataToList(commandList);
                view.onDismissProgress();
            }

            @Override
            public void onFailGetData(String title) {
                view.onShowError(title);
                view.onDismissProgress();
            }
        });
    }

    @Override
    public void onSaveToPdf(List<Category> categoryList) {
        EventBus.getDefault().postSticky(new CategoryListEvent(categoryList));
        view.onShowProgress();
            model.onSaveToPdf(activity,categoryList, new CreatePdfActivityInteractor.ListenerSaveToPdf() {
                @Override
                public void onSuccessSaveToPdf() {

                    view.onDismissProgress();
                }

                @Override
                public void onFailSaveToPdf(String title) {

                    view.onShowError(title);
                    view.onDismissProgress();
                }

                @Override
                public void onEmptyList(String title) {
                    view.onShowEmpty(title);
                    view.onDismissProgress();
                }
            });
    }


}
