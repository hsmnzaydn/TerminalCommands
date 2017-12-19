package hsmnzaydn.serkanozaydin.net.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.model.Category;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hsmnzaydn on 18.12.2017.
 */

public class  CreatePdfRecyclerViewAdapter extends RecyclerView.Adapter<CreatePdfRecyclerViewAdapter.ViewHolder> {

    private Activity activity;
    private List<Category> listOfCategory;
    private List<Category> listOfSelectedCategory;


    public CreatePdfRecyclerViewAdapter(Activity activity, List<Category> listOfCategory) {

        this.listOfCategory = listOfCategory;
        this.activity = activity;
        listOfSelectedCategory=new ArrayList<>();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {




        @BindView(R.id.row_create_pdf_category_title)
        TextView categoryTitleTextView;
        @BindView(R.id.row_create_pdf_check_box)
        CheckBox selectedCategory;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);



        }
    }


    public List<Category> getListOfSelectedCategory(){
        return listOfSelectedCategory;
    }

    @Override
    public CreatePdfRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_create_pdf, parent, false);

        CreatePdfRecyclerViewAdapter.ViewHolder view_holder = new CreatePdfRecyclerViewAdapter.ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(final CreatePdfRecyclerViewAdapter.ViewHolder holder, final int position) {
        Category category=listOfCategory.get(position);


        holder.categoryTitleTextView.setText(category.getCategoryName().toString());

        holder.selectedCategory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    listOfSelectedCategory.add(category);
                }else {
                    listOfSelectedCategory.remove(category);
                }
            }
        });



    }


    @Override
    public int getItemCount() {

        return listOfCategory.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}