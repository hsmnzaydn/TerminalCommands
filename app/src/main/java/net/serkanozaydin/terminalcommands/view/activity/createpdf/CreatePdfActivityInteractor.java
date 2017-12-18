package net.serkanozaydin.terminalcommands.view.activity.createpdf;

import android.app.Activity;

import net.serkanozaydin.terminalcommands.model.Category;
import net.serkanozaydin.terminalcommands.model.Command;

import java.util.List;

/**
 * Created by hsmnzaydn on 18.12.2017.
 */

public interface CreatePdfActivityInteractor {
    void onGetDataFromJson(Activity activity,ListenerGetDataFromJson listenerGetDataFromJson);
    void onSaveToPdf(Activity activity,ListenerSaveToPdf listener);

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
