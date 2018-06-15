package net.serkanozaydin.hsmnzaydn.terminalcommands.di;


import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CategoryListActivity.CategoryListActivity;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CommandListActivity.CommandListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hsmnzaydn on 6/4/18.
 */

@Singleton
@Component(modules =  {DaggerModule.class})
public interface DaggerComponent {
    void inject(CategoryListActivity categoryListActivity);
    void inject(CommandListActivity commandListActivity);

}