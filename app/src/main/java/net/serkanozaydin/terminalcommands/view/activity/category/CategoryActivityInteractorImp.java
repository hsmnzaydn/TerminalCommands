package net.serkanozaydin.terminalcommands.view.activity.category;

import android.app.Activity;
import android.view.View;

import net.serkanozaydin.terminalcommands.utility.Constant;
import net.serkanozaydin.terminalcommands.utility.PopupUtils;
import net.serkanozaydin.terminalcommands.utility.Utils;

/**
 * Created by hsmnzaydn on 05.12.2017.
 */

public class CategoryActivityInteractorImp implements CategoryActivityInteractor {
    @Override
    public void languageConfiguration(Activity activity, LoadDataListener listener) {

        String language=Utils.getCurrentLanguage();
        if(language == null){
            listener.onFail();
        }else {
            if(language.equals(Constant.ENGLISH)){
                listener.onEnglish(Utils.getDataFromRaw(activity,Constant.ENGLISH));
            }
            else if (language.equals(Constant.TURKISH)){
                listener.onTurkish(Utils.getDataFromRaw(activity,Constant.TURKISH));
            }
            else {
                listener.onEnglish(Utils.getDataFromRaw(activity,Constant.ENGLISH));
            }
        }

    }

    @Override
    public void openSaveCommandPopup(Activity activity, View view) {
        PopupUtils.addCommand(activity,view);
    }


}
