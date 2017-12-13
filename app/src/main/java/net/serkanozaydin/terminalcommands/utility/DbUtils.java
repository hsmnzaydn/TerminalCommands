package net.serkanozaydin.terminalcommands.utility;

import android.app.Activity;
import android.arch.persistence.room.Room;

import net.serkanozaydin.terminalcommands.db.AppDatabase;
import net.serkanozaydin.terminalcommands.model.Command;

import java.util.List;

/**
 * Created by hsmnzaydn on 13.12.2017.
 */

public class DbUtils {

    public static AppDatabase getDb(Activity activity){
        AppDatabase database= Room.databaseBuilder(activity,AppDatabase.class, Constant.DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
        return database;
    }

    public static void saveCommandToDB(Activity activity,Command command){
        AppDatabase database= Room.databaseBuilder(activity,AppDatabase.class, Constant.DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
        database.commandDao().insertAll(command);
    }


    public static List<Command> getAllCommands(Activity activity){
        AppDatabase db=getDb(activity);
        return db.commandDao().getAllCommands();
    }
}
