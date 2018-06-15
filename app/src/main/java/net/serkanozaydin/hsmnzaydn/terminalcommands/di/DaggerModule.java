package net.serkanozaydin.hsmnzaydn.terminalcommands.di;

import android.app.Application;
import android.content.Context;

import net.serkanozaydin.hsmnzaydn.terminalcommands.data.AppDataManager;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.DataManager;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.ApiHelper;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.AppApiHelper;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.CategoryService;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.CategoryServiceImp;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.CommandService;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.CommandServiceImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hsmnzaydn on 6/4/18.
 */

@Module
public class DaggerModule {


    private Context context;

    public DaggerModule(Application app) {
        this.context = app;
    }



    @Provides
    Context providesContext() {
        return context;
    }



    @Provides
    @Singleton
    DataManager provideDataManager(ApiHelper apiHelper){
        return new AppDataManager(apiHelper);
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper(CommandService commandService, CategoryService categoryService){
        return new AppApiHelper(commandService,categoryService);
    }

    @Provides
    @Singleton
    CommandService provideCommandService(){
        return new CommandServiceImp();
    }

    @Provides
    @Singleton
    CategoryService proviceCategoryService(){
        return new CategoryServiceImp();
    }


}