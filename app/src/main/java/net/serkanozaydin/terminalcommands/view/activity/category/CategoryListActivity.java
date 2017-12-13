package net.serkanozaydin.terminalcommands.view.activity.category;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.serkanozaydin.terminalcommands.EventBus.CommandListEvent;
import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.db.AppDatabase;
import net.serkanozaydin.terminalcommands.model.Category;
import net.serkanozaydin.terminalcommands.model.Command;
import net.serkanozaydin.terminalcommands.utility.Constant;
import net.serkanozaydin.terminalcommands.utility.PopupUtils;
import net.serkanozaydin.terminalcommands.utility.Utils;
import net.serkanozaydin.terminalcommands.view.Listener.RecyclerItemClickListener;
import net.serkanozaydin.terminalcommands.view.activity.command.CommandListActivity;
import net.serkanozaydin.terminalcommands.view.adapter.CategoryRecyclerViewAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryListActivity extends AppCompatActivity implements CategoryActivityView {
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
        init();


        ButterKnife.bind(this);
        categoryActivityPresenterImp = new CategoryActivityPresenterImp(new CategoryActivityInteractorImp(), this);
        categoryActivityPresenterImp.onConfiguration(CategoryListActivity.this);



        addCommandCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupUtils.addCommand(CategoryListActivity.this,view);
            }
        });




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
}
