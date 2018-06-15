package net.serkanozaydin.hsmnzaydn.terminalcommands.data.network;

import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.CategoryService;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.CommandService;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.ServiceCallback;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Category;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Command;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.CommonResponse;

import java.util.List;

import javax.inject.Inject;

public class AppApiHelper implements ApiHelper {

    CommandService commandService;
    CategoryService categoryService;
    @Inject
    public AppApiHelper(CommandService commandService,CategoryService categoryService) {
       this.commandService=commandService;
       this.categoryService=categoryService;

    }


    @Override
    public void getCommands(String language, ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        commandService.getCommands(language,listServiceCallback,commonResponseServiceCallback);
    }

    @Override
    public void getCategories(String language,ServiceCallback<List<Category>> listServiceCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        categoryService.getCategories(language,listServiceCallback,commonResponseServiceCallback);
    }

    @Override
    public void getCommandsOfCategory(String categoryId, ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        categoryService.getCommandsOfCategory(categoryId,listServiceCallback,commonResponseServiceCallback);
    }
}
