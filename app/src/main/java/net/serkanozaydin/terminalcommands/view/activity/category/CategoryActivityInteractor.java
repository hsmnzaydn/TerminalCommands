package net.serkanozaydin.terminalcommands.view.activity.category;

import android.app.Activity;

/**
 * Created by hsmnzaydn on 05.12.2017.
 */

public interface CategoryActivityInteractor {


    void languageConfiguration(Activity activity, LoadDataListener listener);


    interface LoadDataListener {
        void onTurkish();
        void onEnglish();

        void onFail();
    }


}
