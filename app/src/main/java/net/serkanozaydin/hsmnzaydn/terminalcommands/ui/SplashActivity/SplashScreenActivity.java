package net.serkanozaydin.hsmnzaydn.terminalcommands.ui.SplashActivity;

import android.os.Bundle;

import net.serkanozaydin.hsmnzaydn.terminalcommands.R;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CategoryListActivity.CategoryListActivity;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.base.BaseActivity;
import net.serkanozaydin.hsmnzaydn.terminalcommands.utility.Utils;

public class SplashScreenActivity extends BaseActivity implements SplashScreenActivityMvpView {

    private SplashScreenActivityPresenter splashScreenActivityPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splashScreenActivityPresenter=new SplashScreenActivityPresenter(this);
        splashScreenActivityPresenter.openCategoryList();
    }

    @Override
    public void changeToCategoryList() {
        Utils.changeActivity(this, CategoryListActivity.class);

    }
}
