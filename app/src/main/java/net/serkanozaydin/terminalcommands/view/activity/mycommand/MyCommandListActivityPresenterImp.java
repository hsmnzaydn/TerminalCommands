package net.serkanozaydin.terminalcommands.view.activity.mycommand;

import android.app.Activity;

import net.serkanozaydin.terminalcommands.model.Command;

import java.util.List;

/**
 * Created by hsmnzaydn on 13.12.2017.
 */

public class MyCommandListActivityPresenterImp  implements  MyCommandListActivityPresenter{
    private MyCommandListActivityInteractor model;
    private MyCommandListActivityView view;

    public MyCommandListActivityPresenterImp(MyCommandListActivityInteractor model, MyCommandListActivityView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void Loading(Activity activity) {
        view.onShowLoading();
        model.loadData(activity, new MyCommandListActivityInteractor.Listener() {
            @Override
            public void onSuccess(List<Command> commandList) {

                view.onLoadDataToList(commandList);
                view.onDismissLoading();
            }

            @Override
            public void onEmpty(String emptyText) {

                view.onShowEmptyText(emptyText);
                view.onDismissLoading();
            }
        });



    }
}
