package net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services;

import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Category;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Command;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.CommonResponse;

import java.util.List;

public interface CategoryService {
    void getCategories(String language,ServiceCallback<List<Category>> listServiceCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback);
    void getCommandsOfCategory(String categoryId, ServiceCallback<List<Command>> listServiceCallback,ServiceCallback<CommonResponse> commonResponseServiceCallback);
}
