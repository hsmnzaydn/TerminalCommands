package hsmnzaydn.serkanozaydin.net.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hsmnzaydn.serkanozaydin.net.view.activity.category.CategoryListActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreenActivity.this, CategoryListActivity.class);
                startActivity(intent);
                SplashScreenActivity.this.finish();
            }
        },3000);

    }
}
