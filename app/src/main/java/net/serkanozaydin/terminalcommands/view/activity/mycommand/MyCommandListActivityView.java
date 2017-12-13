package net.serkanozaydin.terminalcommands.view.activity.mycommand;

import net.serkanozaydin.terminalcommands.model.Command;

import java.util.List;

/**
 * Created by hsmnzaydn on 13.12.2017.
 */

public interface MyCommandListActivityView {
    void onShowLoading();
    void onDismissLoading();
    void onLoadDataToList(List<Command> commandList);
    void onShowEmptyText(String text);


}
