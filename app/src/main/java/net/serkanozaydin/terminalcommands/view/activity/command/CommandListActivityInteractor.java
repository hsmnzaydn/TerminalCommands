package net.serkanozaydin.terminalcommands.view.activity.command;

import android.app.Activity;

import net.serkanozaydin.terminalcommands.model.Command;

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
