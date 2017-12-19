package hsmnzaydn.serkanozaydin.net.view.activity.category;

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

import hsmnzaydn.serkanozaydin.net.EventBus.CategoryListEvent;
import hsmnzaydn.serkanozaydin.net.EventBus.CommandListEvent;
import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.model.Category;

import hsmnzaydn.serkanozaydin.net.utility.PopupUtils;
import hsmnzaydn.serkanozaydin.net.utility.Utils;
import hsmnzaydn.serkanozaydin.net.view.Listener.RecyclerItemClickListener;
import hsmnzaydn.serkanozaydin.net.view.activity.command.CommandListActivity;
import hsmnzaydn.serkanozaydin.net.view.activity.createpdf.CreatePdfActivity;
import hsmnzaydn.serkanozaydin.net.view.activity.mycommand.MyCommandListActivity;
import hsmnzaydn.serkanozaydin.net.view.adapter.CategoryRecyclerViewAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryListActivity extends AppCompatActivity implements CategoryActivityView, NavigationView.OnNavigationItemSelectedListener {
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
    private List<Category> categoryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();


        ButterKnife.bind(this);
        categoryActivityPresenterImp = new CategoryActivityPresenterImp(CategoryListActivity.this, new CategoryActivityInteractorImp(), this);
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
        categoryList = listOfCategory;
        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(CategoryListActivity.this, listOfCategory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(categoryRecyclerViewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final LinearLayoutManager layoutManager = new LinearLayoutManager(CategoryListActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(CategoryListActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        EventBus.getDefault().postSticky(new CommandListEvent(listOfCategory.get(position).getCommands()));
                        Utils.changeActivity(CategoryListActivity.this, CommandListActivity.class);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

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
        getMenuInflater().inflate(R.menu.menu_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_search_search) {
            EventBus.getDefault().postSticky(new CategoryListEvent(categoryList));
            Utils.changeActivity(CategoryListActivity.this, CommandListActivity.class);
        }
        return super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my_command) {
            Utils.changeActivity(CategoryListActivity.this, MyCommandListActivity.class);
        } else if (id == R.id.nav_create_pdf) {
            Utils.changeActivity(CategoryListActivity.this, CreatePdfActivity.class);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}