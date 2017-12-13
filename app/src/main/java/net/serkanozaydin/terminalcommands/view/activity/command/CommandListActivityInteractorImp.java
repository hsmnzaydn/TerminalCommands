package net.serkanozaydin.terminalcommands.view.activity.command;

import android.app.Activity;

import net.serkanozaydin.terminalcommands.EventBus.CommandListEvent;
import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.model.Command;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by hsmnzaydn on 12/12/17.
 */

public class CommandListActivityInteractorImp implements CommandListActivityInteractor {

    private List<Command> commandList;


    @Override
    public void loadData(Activity activity, LoadDataListener listener) {
        EventBus.getDefault().register(this);
        if (commandList != null) {
            listener.onSuccess(commandList);
        } else {
            listener.onFail(activity.getString(R.string.error_there_is_problem));
        }
        EventBus.getDefault().unregister(this);



    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getCommandList(CommandListEvent commandListEvent) {
        commandList = commandListEvent.getCommandList();
    }
}
