package net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CategoryListActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.serkanozaydin.hsmnzaydn.terminalcommands.EventBus.CategoryEvent;
import net.serkanozaydin.hsmnzaydn.terminalcommands.R;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.DataManager;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Category;
import net.serkanozaydin.hsmnzaydn.terminalcommands.di.DaggerApplication;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.Adapters.CategoryListRecylerView;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.CommandListActivity.CommandListActivity;
import net.serkanozaydin.hsmnzaydn.terminalcommands.ui.base.BaseActivity;
import net.serkanozaydin.hsmnzaydn.terminalcommands.utility.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryListActivity extends BaseActivity implements CategoryListActivityMvpView {


    @Inject
    DataManager dataManager;

    @BindView(R.id.activity_category_list_recylerview)
    RecyclerView activityCategoryListRecylerview;


    private CategoryListActivityPresenter presenter;
    private CategoryListRecylerView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(CategoryListActivity.this);

        presenter = new CategoryListActivityPresenter(this, dataManager);
       presenter.getCategoryList("ENG");

        //TODO: CHANGE LANGUAGE GET FROM PREF

    }

    @Override
    public void loadDataToRecyclerview(List<Category> listOfCategory) {
        adapter=new CategoryListRecylerView(listOfCategory, new CategoryListRecylerView.ItemListener() {
            @Override
            public void onItemClick(Category item) {
                EventBus.getDefault().postSticky(new CategoryEvent(item));
                Utils.changeActivity(CategoryListActivity.this,CommandListActivity.class);
            }
        });
        activityCategoryListRecylerview.setLayoutManager(new LinearLayoutManager(this));
        activityCategoryListRecylerview.setAdapter(adapter);
    }

}
