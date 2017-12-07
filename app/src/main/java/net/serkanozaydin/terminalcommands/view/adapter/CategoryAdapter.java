package net.serkanozaydin.terminalcommands.view.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.model.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hsmnzaydn on 07.12.2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Activity activity;
    private List<Category> listOfCategory;


    public CategoryAdapter(Activity activity,List<Category> listOfCategory) {

        this.listOfCategory = listOfCategory;
        this.activity = activity;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.row_category_card_view) CardView cardView;
        @BindView(R.id.row_category_thumbnail)  ImageView categoryThumbNailImageView;
        @BindView(R.id.row_category_name_textview) TextView categoryTitleTextView;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);



        }
    }


    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category, parent, false);

        CategoryAdapter.ViewHolder view_holder = new CategoryAdapter.ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(final CategoryAdapter.ViewHolder holder, final int position) {
        Category category=listOfCategory.get(position);


        int imageResource = activity.getResources().getIdentifier(category.getCategoryThumbnail().toString() , "drawable", activity.getPackageName());
        holder.categoryThumbNailImageView.setImageResource(imageResource);
        holder.categoryTitleTextView.setText(category.getCategoryName().toString());




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

