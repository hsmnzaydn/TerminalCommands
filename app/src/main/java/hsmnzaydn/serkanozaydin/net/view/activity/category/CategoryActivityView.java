package hsmnzaydn.serkanozaydin.net.view.activity.category;

import android.view.View;

import hsmnzaydn.serkanozaydin.net.model.Category;

import java.util.List;

/**
 * Created by hsmnzaydn on 05.12.2017.
 */

public interface CategoryActivityView {

    void onShowLoading();
    void onShowError();
    void onDismissLoading();
    void onLoadingDataToList(List<Category> listOfCategory);
    void onOpenSaveCommandPopup(View view);



}
