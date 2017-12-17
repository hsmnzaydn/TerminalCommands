package net.serkanozaydin.terminalcommands.view.activity.category;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import net.serkanozaydin.terminalcommands.EventBus.CommandListEvent;
import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.model.Category;

import net.serkanozaydin.terminalcommands.utility.PopupUtils;
import net.serkanozaydin.terminalcommands.utility.Utils;
import net.serkanozaydin.terminalcommands.view.Listener.RecyclerItemClickListener;
import net.serkanozaydin.terminalcommands.view.activity.command.CommandListActivity;
import net.serkanozaydin.terminalcommands.view.activity.mycommand.MyCommandListActivity;
import net.serkanozaydin.terminalcommands.view.adapter.CategoryRecyclerViewAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryListActivity extends AppCompatActivity implements CategoryActivityView,NavigationView.OnNavigationItemSelectedListener {
    private CategoryActivityPresenterImp categoryActivityPresenterImp;
    private ProgressDialog progressDialog;
    private CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;

    @BindView(R.id.activity_category_recyclerview)
    RecyclerView recyclerView;
    @BindString(R.string.error)
    String errorTitle;
    @BindString(R.string.error_choice_language)
    String choiceLanguage;
    @BindView(R.id.activity_category_list_float_action_button)
    FloatingActionButton addCommandCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();


        ButterKnife.bind(this);
        categoryActivityPresenterImp = new CategoryActivityPresenterImp(CategoryListActivity.this,new CategoryActivityInteractorImp(), this);
        categoryActivityPresenterImp.onConfiguration();


        addCommandCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOpenSaveCommandPopup(view);
            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




    }

    public void init() {
        progressDialog = Utils.createProgressNoBackGroundDialog(CategoryListActivity.this);
    }




    @Override
    public void onShowLoading() {
        progressDialog.show();
    }



    @SuppressLint("ResourceType")
    @Override
    public void onShowError() {
        PopupUtils.errorPopup(CategoryListActivity.this, errorTitle, choiceLanguage, getWindow().getDecorView().findViewById(R.layout.activity_category_list));

    }

    @Override
    public void onDismissLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void onLoadingDataToList(final List<Category> listOfCategory) {

        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(CategoryListActivity.this,listOfCategory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(categoryRecyclerViewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final LinearLayoutManager layoutManager = new LinearLayoutManager(CategoryListActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(CategoryListActivity.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        EventBus.getDefault().postSticky(new CommandListEvent(listOfCategory.get(position).getCommands()));
                        Utils.changeActivity(CategoryListActivity.this, CommandListActivity.class);

                    }

                    @Override public void onLongItemClick(View view, int position) {

                    }
                })
        );


    }

    @Override
    public void onOpenSaveCommandPopup(View view) {
        categoryActivityPresenterImp.onOpenPopup(view);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Utils.changeActivity(CategoryListActivity.this, MyCommandListActivity.class);

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
