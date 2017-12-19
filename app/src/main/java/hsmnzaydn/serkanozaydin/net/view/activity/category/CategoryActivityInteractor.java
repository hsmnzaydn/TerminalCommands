package hsmnzaydn.serkanozaydin.net.view.activity.category;

import android.app.Activity;
import android.view.View;

import hsmnzaydn.serkanozaydin.net.model.Category;

import java.util.List;

/**
 * Created by hsmnzaydn on 05.12.2017.
 */

public interface CategoryActivityInteractor {


    void languageConfiguration(Activity activity, LoadDataListener listener);
    void openSaveCommandPopup(Activity activity, View view);


    interface LoadDataListener {
        void onTurkish(List<Category> categoryList);
        void onEnglish(List<Category> categoryList);

        void onFail();
    }


}
