package net.serkanozaydin.hsmnzaydn.terminalcommands.data;

import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.ApiHelper;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.ServiceCallback;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Category;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Command;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.CommonResponse;

import java.util.List;

import javax.inject.Inject;

public class AppDataManager implements DataManager {
    ApiHelper apiHelper;


    @Inject
    public AppDataManager(ApiHelper apiHelper){
        this.apiHelper=apiHelper;
    }


    @Override
    public void getCommands( String language,ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiHelper.getCommands(language,listServiceCallback,commonResponseServiceCallback);
    }

    @Override
    public void getCategories(String language,ServiceCallback<List<Category>> listServiceCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiHelper.getCategories(language,listServiceCallback,commonResponseServiceCallback);
    }

    @Override
    public void getCommandsOfCategory(String categoryId, ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiHelper.getCommandsOfCategory(categoryId,listServiceCallback,commonResponseServiceCallback);
    }


}
