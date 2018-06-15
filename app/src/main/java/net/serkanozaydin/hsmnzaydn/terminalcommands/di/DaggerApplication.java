package net.serkanozaydin.hsmnzaydn.terminalcommands.di;

import android.app.Application;

import dagger.Module;

/**
 * Created by hsmnzaydn on 6/4/18.
 */

@Module
public class DaggerApplication extends Application {


    private DaggerComponent daggerComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        daggerComponent = createDaggerComponent();
    }

    public DaggerComponent getDaggerComponent() {
        return daggerComponent == null ? createDaggerComponent() : daggerComponent;
    }


    private DaggerComponent createDaggerComponent() {
        return DaggerDaggerComponent.builder().daggerModule(new DaggerModule(this)).build();
    }

    public void clearComponent() {
        daggerComponent = null;
    }


}