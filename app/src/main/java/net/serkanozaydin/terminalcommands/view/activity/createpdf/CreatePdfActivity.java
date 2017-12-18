package net.serkanozaydin.terminalcommands.view.activity.createpdf;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.model.Category;
import net.serkanozaydin.terminalcommands.utility.Utils;
import net.serkanozaydin.terminalcommands.view.activity.category.CategoryListActivity;
import net.serkanozaydin.terminalcommands.view.adapter.CategoryRecyclerViewAdapter;
import net.serkanozaydin.terminalcommands.view.adapter.CreatePdfRecyclerViewAdapter;

import java.util.List;

public class CreatePdfActivity extends AppCompatActivity implements CreatePdfActivityView {
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private CreatePdfRecyclerViewAdapter recyclerViewAdapter;
    private CreatePdfActivityPresenterImp createPdfActivityPresenterImp;
    private Button transferToPdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pdf);
        init();
        createPdfActivityPresenterImp=new CreatePdfActivityPresenterImp(new CreatePdfActivityInteractorImp(),this,CreatePdfActivity.this);
        createPdfActivityPresenterImp.onSuccessConfiguration();


        transferToPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPdfActivityPresenterImp.onSaveToPdf(recyclerViewAdapter.getListOfSelectedCategory());
            }
        });
    }


    public void init(){
        progressDialog= Utils.createProgressNoBackGroundDialog(CreatePdfActivity.this);
        recyclerView=findViewById(R.id.activity_create_pdf_recyclerview);
        transferToPdf=findViewById(R.id.activity_create_pdf_button);
    }
    @Override
    public void onShowProgress() {
        progressDialog.show();
    }

    @Override
    public void onDismissProgress() {
    progressDialog.dismiss();
    }

    @Override
    public void onDataToList(List<Category> categoryList) {

        recyclerViewAdapter = new CreatePdfRecyclerViewAdapter(CreatePdfActivity.this,categoryList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final LinearLayoutManager layoutManager = new LinearLayoutManager(CreatePdfActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onShowError(String error) {
        Toast.makeText(CreatePdfActivity.this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowEmpty(String title) {
        Toast.makeText(CreatePdfActivity.this,title,Toast.LENGTH_SHORT).show();
    }
}