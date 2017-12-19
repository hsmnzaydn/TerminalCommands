package hsmnzaydn.serkanozaydin.net.view.activity.command;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.model.Command;
import hsmnzaydn.serkanozaydin.net.utility.Utils;
import hsmnzaydn.serkanozaydin.net.controller.ActivityController;
import hsmnzaydn.serkanozaydin.net.view.adapter.CommandRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CommandListActivity extends ActivityController implements CommandListActivityView, SearchView.OnQueryTextListener {
    private CommandListActivityPresenterImp presenterImp;
    private ProgressDialog progressDialog;
    private List<Command> commandList;

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
        commandList=listOfCommand;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search_search);
        searchItem.expandActionView();
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();

        ArrayList<Command> newList=new ArrayList<>();
        for(Command command:commandList){
            String name=command.getCommandName().toLowerCase();
            if(name.contains(newText))
                newList.add(command);
        }

        adapter.setFilter(newList);
        return false;
    }

    @Override
    public void showError(String errorTitle) {
        Toast.makeText(CommandListActivity.this,errorTitle,Toast.LENGTH_SHORT).show();
    }
}
