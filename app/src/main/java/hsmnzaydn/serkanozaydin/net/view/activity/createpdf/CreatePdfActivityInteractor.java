package hsmnzaydn.serkanozaydin.net.view.activity.createpdf;

import android.app.Activity;

import hsmnzaydn.serkanozaydin.net.model.Category;

import java.util.List;

/**
 * Created by hsmnzaydn on 18.12.2017.
 */

public interface CreatePdfActivityInteractor {
    void onGetDataFromJson(Activity activity,ListenerGetDataFromJson listenerGetDataFromJson);
    void onSaveToPdf(Activity activity,List<Category> categoryList,ListenerSaveToPdf listener);

    interface ListenerGetDataFromJson{
        void onSuccessGetData(List<Category> commandList);
        void onFailGetData(String title);



    }

    interface ListenerSaveToPdf{
        void onSuccessSaveToPdf();
        void onFailSaveToPdf(String title);
        void onEmptyList(String title);
    }




}
