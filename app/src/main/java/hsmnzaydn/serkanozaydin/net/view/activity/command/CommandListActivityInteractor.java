package hsmnzaydn.serkanozaydin.net.view.activity.command;

import android.app.Activity;

import hsmnzaydn.serkanozaydin.net.model.Command;

import java.util.List;

/**
 * Created by hsmnzaydn on 12/12/17.
 */

public interface CommandListActivityInteractor {

    void loadData(Activity activity,LoadDataListener listener);

    interface LoadDataListener{
        void onSuccess(List<Command> listOfCommand);
        void onFail(String title);
    }

}
