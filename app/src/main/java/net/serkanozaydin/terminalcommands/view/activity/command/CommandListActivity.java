package net.serkanozaydin.terminalcommands.view.activity.command;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.model.Command;
import net.serkanozaydin.terminalcommands.utility.PopupUtils;
import net.serkanozaydin.terminalcommands.utility.Utils;
import net.serkanozaydin.terminalcommands.controller.ActivityController;
import net.serkanozaydin.terminalcommands.view.adapter.CommandRecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;

public class CommandListActivity extends ActivityController implements CommandListActivityView {
    private CommandListActivityPresenterImp presenterImp;
    private ProgressDialog progressDialog;

    @BindView(R.id.activity_command_recyclerview)
    RecyclerView recyclerView;

    private CommandRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command_list);
        init();


        presenterImp = new CommandListActivityPresenterImp(new CommandListActivityInteractorImp(), this);
        presenterImp.onGetData(CommandListActivity.this);
    }


    public void init() {
        progressDialog = Utils.createProgressNoBackGroundDialog(CommandListActivity.this);
    }

    @Override
    public void getData(List<Command> listOfCommand) {
        recyclerView=findViewById(R.id.activity_command_recyclerview);
        adapter = new CommandRecyclerViewAdapter(CommandListActivity.this, listOfCommand);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(CommandListActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void dismissProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showError(String errorTitle) {
        PopupUtils.errorPopup(CommandListActivity.this, getString(R.string.error), errorTitle, getWindow().getDecorView().findViewById(R.layout.activity_command_list));
    }
}
