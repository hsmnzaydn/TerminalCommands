package net.serkanozaydin.hsmnzaydn.terminalcommands.ui.SplashActivity;

import android.app.Activity;
import android.os.Handler;

import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CategoryListActivity.CategoryListActivity;

import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.base.BasePresenter;
import net.serkanozaydin.hsmnzaydn.terminalcommands.utility.Constant;
import net.serkanozaydin.hsmnzaydn.terminalcommands.utility.Utils;



/**
 * Created by hsmnzaydn on 6/14/18.
 */

public class SplashScreenActivityPresenter<V extends SplashScreenActivityMvpView> extends BasePresenter<V> implements SplashScreenActivityMvpPresenter<V> {
   private Activity activity;
    public SplashScreenActivityPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public void openCategoryList() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getMvpView().changeToCategoryList();

            }
        }, Constant.SPLASH_TIME);
    }
}
