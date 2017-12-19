package hsmnzaydn.serkanozaydin.net.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.model.Command;
import hsmnzaydn.serkanozaydin.net.utility.DbUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hsmnzaydn on 16.12.2017.
 */

public class MyCommandRecyclerViewAdapter extends RecyclerView.Adapter<MyCommandRecyclerViewAdapter.ViewHolder> {

    private Activity activity;
    private List<Command> listOfCommand;


    public MyCommandRecyclerViewAdapter(Activity activity, List<Command> listOfCommand) {

        this.listOfCommand = listOfCommand;
        this.activity = activity;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {



        @BindView(R.id.row_my_commands_title_textview)
        TextView commandTitleTextView;
        @BindView(R.id.row_my_commands_detail_textview)
        TextView commandDetailTextView;
        @BindView(R.id.row_commands_delete_image_view)
        ImageView commandFavouriteImageView;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);



        }
    }


    @Override
    public MyCommandRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_my_commands, parent, false);

        MyCommandRecyclerViewAdapter.ViewHolder view_holder = new MyCommandRecyclerViewAdapter.ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(final MyCommandRecyclerViewAdapter.ViewHolder holder, final int position) {
        Command command=listOfCommand.get(position);

        holder.commandTitleTextView.setText(command.getCommandName());
        holder.commandDetailTextView.setText(command.getDetail());
        holder.commandFavouriteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listOfCommand.remove(position);
                DbUtils.deleteCommand(activity,command);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {

        return listOfCommand.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}
