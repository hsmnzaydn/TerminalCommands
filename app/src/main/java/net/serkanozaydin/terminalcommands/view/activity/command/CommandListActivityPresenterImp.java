package net.serkanozaydin.terminalcommands.view.activity.command;

import android.app.Activity;

import net.serkanozaydin.terminalcommands.model.Command;

import java.util.List;

/**
 * Created by hsmnzaydn on 12/12/17.
 */

public class CommandListActivityPresenterImp implements CommandListActivityPresenter{
    private CommandListActivityInteractor model;
    private CommandListActivityView view;

    public CommandListActivityPresenterImp(CommandListActivityInteractor model, CommandListActivityView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onGetData(Activity activity) {
        view.showProgress();
        model.loadData(activity, new CommandListActivityInteractor.LoadDataListener() {
            @Override
            public void onSuccess(List<Command> listOfCommand) {
                view.getData(listOfCommand);
                view.dismissProgress();
            }

            @Override
            public void onFail(String title) {
                view.showError(title);
                view.dismissProgress();
            }
        });
    }
}
