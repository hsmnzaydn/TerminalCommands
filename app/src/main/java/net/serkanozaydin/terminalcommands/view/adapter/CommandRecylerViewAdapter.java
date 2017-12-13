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
import net.serkanozaydin.terminalcommands.model.Command;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hsmnzaydn on 12/12/17.
 */

public class CommandRecylerViewAdapter  extends RecyclerView.Adapter<CommandRecylerViewAdapter.ViewHolder> {

    private Activity activity;
    private List<Command> listOfCommand;


    public CommandRecylerViewAdapter(Activity activity, List<Command> listOfCommand) {

        this.listOfCommand = listOfCommand;
        this.activity = activity;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {



        @BindView(R.id.row_command_title_textview)
        TextView commandTitleTextView;
        @BindView(R.id.row_command_detail_textview)
        TextView commandDetailTextView;
        @BindView(R.id.row_command_favourite_image_view)
        ImageView commandFavouriteImageView;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);



        }
    }


    @Override
    public CommandRecylerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_command, parent, false);

        CommandRecylerViewAdapter.ViewHolder view_holder = new CommandRecylerViewAdapter.ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(final CommandRecylerViewAdapter.ViewHolder holder, final int position) {
        Command command=listOfCommand.get(position);

        holder.commandTitleTextView.setText(command.getCommandName());
        holder.commandDetailTextView.setText(command.getDetail());
        holder.commandFavouriteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.commandFavouriteImageView.setImageResource(R.drawable.action_fill_star);
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