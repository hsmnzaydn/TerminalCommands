package hsmnzaydn.serkanozaydin.net.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.view.activity.category.CategoryListActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Intent intent=new Intent(SplashScreenActivity.this, CategoryListActivity.class);
        startActivity(intent);
        this.finish();
    }
}
