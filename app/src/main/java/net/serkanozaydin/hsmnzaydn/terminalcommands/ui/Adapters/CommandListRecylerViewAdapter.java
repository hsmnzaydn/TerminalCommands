package net.serkanozaydin.hsmnzaydn.terminalcommands.ui.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.serkanozaydin.hsmnzaydn.terminalcommands.R;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Command;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CommandListRecylerViewAdapter extends RecyclerView.Adapter<CommandListRecylerViewAdapter.ViewHolder> {


    private List<Command> myItems;
    private ItemListener myListener;

    public CommandListRecylerViewAdapter(List<Command> items, ItemListener listener) {
        myItems = items;
        myListener = listener;
    }

    public void setListener(ItemListener listener) {
        myListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_command, parent, false)); // TODO
    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(myItems.get(position));
    }

    public interface ItemListener {
        void onItemClick(Command item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // TODO - Your view members
        public Command item;

        @BindView(R.id.row_command_title_text_view)
        TextView rowCommandTitleTextView;
        @BindView(R.id.row_command_detail_text_view)
        TextView rowCommandDetailTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            // TODO instantiate/assign view members
            ButterKnife.bind(this, itemView);
        }

        public void setData(Command item) {
            this.item = item;
            // TODO set data to view
            rowCommandTitleTextView.setText(item.getText());
            rowCommandDetailTextView.setText(item.getDetail());
        }

        @Override
        public void onClick(View v) {
            if (myListener != null) {
                myListener.onItemClick(item);
            }
        }
    }


}
                                