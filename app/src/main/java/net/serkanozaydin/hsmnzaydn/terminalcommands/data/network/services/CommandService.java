package net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services;

import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Command;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.CommonResponse;

import java.util.List;

public interface CommandService {

    void getCommands(String language, ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponse> commonResponseServiceCallback);
}
