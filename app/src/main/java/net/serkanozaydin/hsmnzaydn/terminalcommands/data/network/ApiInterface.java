package net.serkanozaydin.hsmnzaydn.terminalcommands.data.network;





import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Category;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Command;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiInterface {

    @GET("commands")
    Observable<List<Command>> getCommands(@Query("language") String language);

    @GET("categories")
    Observable<List<Category>> getCategory(@Query("language") String language);

    @GET("categories/{categoryId}/commands")
    Observable<List<Command>> getCommandsOfCategory(@Path("categoryId") String categoryId);
}
