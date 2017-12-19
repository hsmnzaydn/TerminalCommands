package hsmnzaydn.serkanozaydin.net.view.activity.mycommand;

import android.app.Activity;

import hsmnzaydn.serkanozaydin.net.model.Command;

import java.util.List;

/**
 * Created by hsmnzaydn on 13.12.2017.
 */

public interface MyCommandListActivityInteractor {
    void loadData(Activity activity, Listener listener);


    interface Listener{
        void onSuccess(List<Command> commandList);
        void onEmpty(String emptyText);

    }



}
