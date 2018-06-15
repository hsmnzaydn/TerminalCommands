package net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CommandListActivity;

import android.app.Activity;

import net.serkanozaydin.hsmnzaydn.terminalcommands.data.DataManager;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.ServiceCallback;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Command;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.CommonResponse;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.base.BasePresenter;

import java.util.List;

/**
 * Created by hsmnzaydn on 6/15/18.
 */

public class CommandListActivityPresenter<V extends CommandListActivityMvpView> extends BasePresenter<V> implements CommandListActivityMvpPresenter<V> {

    private DataManager dataManager;
    public CommandListActivityPresenter(Activity activity,DataManager dataManager) {
        super(activity);
        this.dataManager=dataManager;
    }

    @Override
    public void getCommands(String categoryId) {
        getMvpView().showLoading();


        dataManager.getCommandsOfCategory(categoryId, new ServiceCallback<List<Command>>() {
            @Override
            public void onResponse(List<Command> response) {
                getMvpView().loadDataToRecylerview(response);
                getMvpView().dissmisLoading();
            }

            @Override
            public void onError(String message) {
                getMvpView().showError(message);
                getMvpView().dissmisLoading();

            }
        }, new ServiceCallback<CommonResponse>() {
            @Override
            public void onResponse(CommonResponse response) {
                getMvpView().showError(response.getMessage());
                getMvpView().dissmisLoading();
            }

            @Override
            public void onError(String message) {
                getMvpView().showError(message);
                getMvpView().dissmisLoading();
            }
        });
    }
}
