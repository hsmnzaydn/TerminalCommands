package net.serkanozaydin.terminalcommands.view.activity.category;

import android.app.Activity;

import net.serkanozaydin.terminalcommands.model.Category;

import java.util.List;

/**
 * Created by hsmnzaydn on 05.12.2017.
 */

public interface CategoryActivityInteractor {


    void languageConfiguration(Activity activity, LoadDataListener listener);


    interface LoadDataListener {
        void onTurkish(List<Category> categoryList);
        void onEnglish(List<Category> categoryList);

        void onFail();
    }


}
