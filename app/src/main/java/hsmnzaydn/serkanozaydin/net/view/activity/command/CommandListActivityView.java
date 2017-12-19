package hsmnzaydn.serkanozaydin.net.view.activity.command;

import hsmnzaydn.serkanozaydin.net.model.Command;

import java.util.List;

/**
 * Created by hsmnzaydn on 12/12/17.
 */

public interface CommandListActivityView {
    void getData(List<Command> listOfCommand);
    void showProgress();
    void dismissProgress();
    void showError(String errorTitle);
}
