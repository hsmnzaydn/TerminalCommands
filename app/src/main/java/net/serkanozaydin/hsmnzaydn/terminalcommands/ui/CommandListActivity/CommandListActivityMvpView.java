package net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CommandListActivity;

import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Command;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.base.MvpView;

import java.util.List;

/**
 * Created by hsmnzaydn on 6/15/18.
 */

public interface CommandListActivityMvpView extends MvpView{

    void loadDataToRecylerview(List<Command> listOfCommand);


}
