package hsmnzaydn.serkanozaydin.net.view.activity.createpdf;

import android.app.Activity;

import hsmnzaydn.serkanozaydin.net.R;
import hsmnzaydn.serkanozaydin.net.model.Category;
import hsmnzaydn.serkanozaydin.net.model.Command;
import hsmnzaydn.serkanozaydin.net.utility.Constant;
import hsmnzaydn.serkanozaydin.net.utility.CreatePdf;
import hsmnzaydn.serkanozaydin.net.utility.Utils;

import java.util.List;

/**
 * Created by hsmnzaydn on 18.12.2017.
 */

public class CreatePdfActivityInteractorImp implements CreatePdfActivityInteractor {

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
    public void onSaveToPdf(Activity activity, List<Category> categoryList,ListenerSaveToPdf listener) {
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




    }


}
