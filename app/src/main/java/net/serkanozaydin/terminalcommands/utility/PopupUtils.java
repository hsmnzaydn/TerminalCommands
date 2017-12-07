package net.serkanozaydin.terminalcommands.utility;

import android.app.Activity;
import android.content.Context;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import net.serkanozaydin.terminalcommands.R;



/**
 * Created by hsmnzaydn on 06.12.2017.
 */

public class PopupUtils {

    public static void errorPopup(final Activity activity,String title,String detail, View parent) {
        final LayoutInflater inflater;
        TextView titleTextView;
        TextView detailTextView;
        Button okButton;


        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View layout = inflater.inflate(R.layout.error_popup,
                (ViewGroup) parent.findViewById(R.id.error_popup_relative_layout));


        final PopupWindow popupError = new PopupWindow(layout, activity.getWindowManager()
                .getDefaultDisplay().getWidth(), activity.getWindowManager()
                .getDefaultDisplay().getHeight(), true);
        popupError.showAtLocation(layout, Gravity.CENTER, 0, 0);

      titleTextView=layout.findViewById(R.id.error_popup_title_text_view);
      detailTextView=layout.findViewById(R.id.error_popup_detail_text_view);
      okButton=layout.findViewById(R.id.error_popup_ok_button);

      titleTextView.setText(title);
      detailTextView.setText(detail);
      okButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              activity.onBackPressed();
          }
      });


    }
}
