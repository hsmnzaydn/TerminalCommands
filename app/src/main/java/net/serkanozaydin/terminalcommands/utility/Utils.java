package net.serkanozaydin.terminalcommands.utility;

import android.app.Activity;
import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.db.AppDatabase;
import net.serkanozaydin.terminalcommands.model.Category;
import net.serkanozaydin.terminalcommands.model.Command;

import java.io.IOException;
import java.io.InputStream;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * Created by hsmnzaydn on 05.12.2017.
 */

public class Utils {

    public static String getCurrentLanguage(){

        return Locale.getDefault().getLanguage();
    }


    public static List<Category> getDataFromRaw(Activity activity,String language) {
        InputStream is = null;

        if (language.equals(Constant.ENGLISH)) {
            try {
                is = activity.getAssets().open("english.json");
            } catch (IOException e) {
                e.printStackTrace();
            }        }
        if (language.equals(Constant.TURKISH)) {
            try {
                is = activity.getAssets().open("turkish.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String json="";
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer);


        } catch (IOException e) {
            e.printStackTrace();
        }


        Gson gson = new Gson();
        Type token = new TypeToken<Collection<Category>>() {}.getType();
        List<Category> result = gson.fromJson(json, token);

    return result;
    }


    public static ProgressDialog createProgressNoBackGroundDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context, R.style.MyProgressDialogStyle);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        return progressDialog;
    }

    public static void dismissProgressDialog(ProgressDialog progressDialog) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    public static void changeActivity(Activity activity,Class goClass){
        Intent intent=new Intent(activity,goClass);
        activity.startActivity(intent);
    }




}
