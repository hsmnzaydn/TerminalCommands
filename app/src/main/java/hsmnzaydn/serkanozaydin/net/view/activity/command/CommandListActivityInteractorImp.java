package hsmnzaydn.serkanozaydin.net.view.activity.command;

import android.app.Activity;

import hsmnzaydn.serkanozaydin.net.EventBus.CategoryListEvent;
import hsmnzaydn.serkanozaydin.net.EventBus.CommandListEvent;
import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.model.Category;
import hsmnzaydn.serkanozaydin.net.model.Command;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
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
            EventBus.getDefault().removeAllStickyEvents();
        } else {
            listener.onFail(activity.getString(R.string.error_there_is_problem));
        }

        EventBus.getDefault().unregister(this);



    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getCommandList(CommandListEvent commandListEvent) {
        commandList = commandListEvent.getCommandList();
    }


    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void getAllCommandList(CategoryListEvent categoryListEvent){
        commandList=new ArrayList<>();
        for(Category category:categoryListEvent.getListOfCategory()){
            commandList.addAll(category.getCommands());
        }

    }
}
