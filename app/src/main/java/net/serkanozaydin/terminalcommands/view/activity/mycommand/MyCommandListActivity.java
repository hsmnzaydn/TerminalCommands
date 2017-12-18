package net.serkanozaydin.terminalcommands.view.activity.mycommand;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.model.Command;
import net.serkanozaydin.terminalcommands.utility.Utils;
import net.serkanozaydin.terminalcommands.controller.ActivityController;
import net.serkanozaydin.terminalcommands.view.adapter.MyCommandRecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCommandListActivity extends ActivityController implements MyCommandListActivityView{
private MyCommandListActivityPresenterImp myCommandListActivityPresenterImp;
private ProgressDialog progressDialog;

@BindView(R.id.activity_my_command_list_recyclerview)
    RecyclerView recyclerView;
@BindView(R.id.activity_my_command_list_empty_text)
    TextView emptyTextView;
    private MyCommandRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_command_list);
        init();
        ButterKnife.bind(this);


        myCommandListActivityPresenterImp =new MyCommandListActivityPresenterImp(new MyCommandListActivtyInteractorImp(),this);
        myCommandListActivityPresenterImp.Loading(MyCommandListActivity.this);

    }


    public void init(){
        progressDialog= Utils.createProgressNoBackGroundDialog(MyCommandListActivity.this);
    }

    @Override
    public void onShowLoading() {
        progressDialog.show();
    }

    @Override
    public void onDismissLoading() {

        progressDialog.dismiss();
    }

    @Override
    public void onLoadDataToList(List<Command> commandList) {

        adapter = new MyCommandRecyclerViewAdapter(MyCommandListActivity.this, commandList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(MyCommandListActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onShowEmptyText(String text) {
        emptyTextView.setVisibility(View.VISIBLE);
        emptyTextView.setText(text);
    }
}
