package hsmnzaydn.serkanozaydin.net.view.activity.mycommand;

import android.app.Activity;

import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.model.Command;
import hsmnzaydn.serkanozaydin.net.utility.DbUtils;

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
