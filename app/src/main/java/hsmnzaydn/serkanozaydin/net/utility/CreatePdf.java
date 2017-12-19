package hsmnzaydn.serkanozaydin.net.utility;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 * Created by hsmnzaydn on 24.07.2017.
 */

public class CreatePdf {
    private String outPath;
    private Context context;


    public CreatePdf(Context context){
        this.setContext(context);
    }




    public void createPDF(String stringBuilder){

        outPath=getContext().getExternalCacheDir()+"/terminalKomutlari.pdf";
        Document doc=new Document();


        try{
            PdfWriter.getInstance(doc,new FileOutputStream(outPath));
            doc.open();
            doc.add(new Paragraph(stringBuilder));
            doc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void shareWithmail(){
        File filelocation = new File(getContext().getExternalCacheDir(), "terminalKomutlari.pdf");
        Uri path = Uri.fromFile(filelocation);
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent .setType("vnd.android.cursor.dir/email");

        emailIntent .putExtra(Intent.EXTRA_EMAIL, "");
        emailIntent .putExtra(Intent.EXTRA_STREAM, path);
        emailIntent .putExtra(Intent.EXTRA_SUBJECT, "Terminal Komutları PDF");
        getContext().startActivity(Intent.createChooser(emailIntent , "https://play.google.com/store/apps/details?id=hsmnzaydn.serkanozaydin.net&hl=tr"));
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
