package hsmnzaydn.serkanozaydin.net.utility;

import android.app.Activity;
import android.arch.persistence.room.Room;

import hsmnzaydn.serkanozaydin.net.db.AppDatabase;
import hsmnzaydn.serkanozaydin.net.model.Command;

import java.util.List;

/**
 * Created by hsmnzaydn on 13.12.2017.
 */

public class DbUtils {

    public static AppDatabase getDb(Activity activity) {
        AppDatabase database = Room.databaseBuilder(activity, AppDatabase.class, Constant.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        return database;
    }

    public static void saveCommandToDB(Activity activity, Command command) {
        AppDatabase database = getDb(activity);
        database.commandDao().insertAll(command);
    }


    public static List<Command> getAllCommands(Activity activity) {
        AppDatabase db = getDb(activity);
        return db.commandDao().getAllCommands();
    }

    public static void deleteCommand(Activity activity, Command command) {
        AppDatabase db = getDb(activity);
        db.commandDao().deleteCommand(command);
    }
}
