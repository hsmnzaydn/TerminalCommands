package net.serkanozaydin.terminalcommands.view.activity.createpdf;

import android.app.Activity;

import net.serkanozaydin.terminalcommands.EventBus.CategoryListEvent;
import net.serkanozaydin.terminalcommands.R;
import net.serkanozaydin.terminalcommands.model.Category;
import net.serkanozaydin.terminalcommands.model.Command;
import net.serkanozaydin.terminalcommands.utility.Constant;
import net.serkanozaydin.terminalcommands.utility.CreatePdf;
import net.serkanozaydin.terminalcommands.utility.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by hsmnzaydn on 18.12.2017.
 */

public class CreatePdfActivityInteractorImp implements CreatePdfActivityInteractor {

    private List<Category> categoryList;
    @Override
    public void onGetDataFromJson(Activity activity, ListenerGetDataFromJson listenerGetDataFromJson) {
        String language=Utils.getCurrentLanguage();
        if(language == null){
            listenerGetDataFromJson.onFailGetData(activity.getString(R.string.error_choice_language));
        }
        else {
            if (language.equals(Constant.TURKISH)) {
                listenerGetDataFromJson.onSuccessGetData(Utils.getDataFromRaw(activity, language));
            } else if (language.equals(Constant.ENGLISH)) {
                listenerGetDataFromJson.onSuccessGetData(Utils.getDataFromRaw(activity, language));
            } else {
                listenerGetDataFromJson.onSuccessGetData(Utils.getDataFromRaw(activity, language));
            }
        }
    }

    @Override
    public void onSaveToPdf(Activity activity, ListenerSaveToPdf listener) {
        EventBus.getDefault().register(this);
        if(categoryList.size() ==0 ){
            listener.onEmptyList(activity.getString(R.string.empty_select_a_category));
        }
        else if(categoryList == null){
            listener.onFailSaveToPdf(activity.getString(R.string.error));
        }else {
            CreatePdf createPdf=new CreatePdf(activity);
            String stringBuilder="";
            for (Category category:categoryList) {
                for(Command command:category.getCommands()){
                    String commandTitle=command.getCommandName();
                    String commandDetail=command.getDetail();
                    String row=commandTitle+"="+commandDetail+"\n";
                    stringBuilder=stringBuilder+row;
                }
            }


            createPdf.createPDF(stringBuilder);
            listener.onSuccessSaveToPdf();
            createPdf.shareWithmail();

        }




        EventBus.getDefault().unregister(this);
    }


    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void getCategoryListEvent(CategoryListEvent categoryListEvent){
        categoryList= categoryListEvent.getListOfCategory();
    }
}
