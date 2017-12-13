package net.serkanozaydin.terminalcommands.utility;

import android.app.Activity;
import android.content.Context;

import android.graphics.Rect;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.model.Command;


/**
 * Created by hsmnzaydn on 06.12.2017.
 */

public class PopupUtils {

    public static void errorPopup(final Activity activity, String title, String detail, View parent) {
        final LayoutInflater inflater;
        TextView titleTextView;
        TextView detailTextView;
        Button okButton;


        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View layout = inflater.inflate(R.layout.popup_error,
                (ViewGroup) parent.findViewById(R.id.error_popup_relative_layout));


        final PopupWindow popupError = new PopupWindow(layout, activity.getWindowManager()
                .getDefaultDisplay().getWidth(), activity.getWindowManager()
                .getDefaultDisplay().getHeight(), true);
        popupError.showAtLocation(layout, Gravity.CENTER, 0, 0);

        titleTextView = layout.findViewById(R.id.error_popup_title_text_view);
        detailTextView = layout.findViewById(R.id.error_popup_detail_text_view);
        okButton = layout.findViewById(R.id.error_popup_ok_button);

        titleTextView.setText(title);
        detailTextView.setText(detail);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });


    }


    public static void addCommand(final Activity activity, View parent) {
        final LayoutInflater inflater;
        EditText titleCommandEditText;
        EditText detailCommandEditText;
        Button saveCommandButton;


        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View layout = inflater.inflate(R.layout.popup_add_new_command,
                (ViewGroup) parent.findViewById(R.id.add_command_popup_relative_layout));



        final PopupWindow popupAddCommand = new PopupWindow(layout, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT,true);
        popupAddCommand.showAtLocation(layout,Gravity.NO_GRAVITY, 0, 0);
        popupAddCommand.showAsDropDown(layout);

        final View root = layout.getRootView();
        root.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                Rect r = new Rect();
                root.getWindowVisibleDisplayFrame(r);
                int heightDiff = r.height() - root.getHeight();
                popupAddCommand.update(0, heightDiff / 2, -1, -1);
            }
        });

        titleCommandEditText=layout.findViewById(R.id.popup_add_new_command_title_edit_text);
        detailCommandEditText=layout.findViewById(R.id.popup_add_new_command_detail_edit_text);
        saveCommandButton=layout.findViewById(R.id.popup_Add_new_command_save_button);


        saveCommandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupAddCommand.dismiss();
                String title=titleCommandEditText.getText().toString();
                String detail=detailCommandEditText.getText().toString();
                DbUtils.saveCommandToDB(activity,new Command(title,detail));
            }
        });





    }
}
