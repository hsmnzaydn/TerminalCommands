package net.serkanozaydin.terminalcommands.view.activity.category;

import android.app.Activity;

import net.serkanozaydin.terminalcommands.utility.Constant;
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
                listener.onEnglish();
            }
            else if (language.equals(Constant.TURKISH)){
                listener.onTurkish();
            }
            else {
                listener.onEnglish();
            }
        }

    }
}
