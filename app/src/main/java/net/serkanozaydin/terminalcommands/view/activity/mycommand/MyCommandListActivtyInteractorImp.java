package net.serkanozaydin.terminalcommands.view.activity.mycommand;

import android.app.Activity;

import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.model.Command;
import net.serkanozaydin.terminalcommands.utility.DbUtils;

import java.util.List;

/**
 * Created by hsmnzaydn on 13.12.2017.
 */

public class MyCommandListActivtyInteractorImp implements MyCommandListActivityInteractor {
    private List<Command> commandList;

    @Override
    public void loadData(Activity activity, Listener listener) {
        commandList= DbUtils.getAllCommands(activity);

        if( commandList.size() != 0){
            listener.onSuccess(commandList);
        }
        else {
            listener.onEmpty(activity.getString(R.string.empty_command_list));
        }
    }
}
