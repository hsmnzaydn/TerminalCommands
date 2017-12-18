package net.serkanozaydin.terminalcommands.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.model.Command;
import net.serkanozaydin.terminalcommands.utility.DbUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static net.serkanozaydin.terminalcommands.utility.DbUtils.getAllCommands;

/**
 * Created by hsmnzaydn on 12/12/17.
 */

public class CommandRecyclerViewAdapter extends RecyclerView.Adapter<CommandRecyclerViewAdapter.ViewHolder> {

    private Activity activity;
    private List<Command> listOfCommand;


    public CommandRecyclerViewAdapter(Activity activity, List<Command> listOfCommand) {

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
    public CommandRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_command, parent, false);
        CommandRecyclerViewAdapter.ViewHolder view_holder = new CommandRecyclerViewAdapter.ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(final CommandRecyclerViewAdapter.ViewHolder holder, final int position) {
        Command command = listOfCommand.get(position);
        command.setFavourite(false);
        holder.commandTitleTextView.setText(command.getCommandName());
        holder.commandDetailTextView.setText(command.getDetail());

        List<Command> commands = DbUtils.getAllCommands(activity);

        command.setFavourite(commands);
        if (command.getFavourite() != null) {
            if (command.getFavourite()) {
                holder.commandFavouriteImageView.setImageResource(R.drawable.action_fill_star);
                holder.setIsRecyclable(false);
            }
        }

        holder.commandFavouriteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (command.getFavourite()) {
                    command.setFavourite(false);
                    DbUtils.deleteCommand(activity, command);
                } else {
                    command.setFavourite(true);
                    holder.commandFavouriteImageView.setImageResource(R.drawable.action_fill_star);
                    holder.setIsRecyclable(false);
                    DbUtils.saveCommandToDB(activity, new Command(command.getCommandName(), command.getDetail()));
                }


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