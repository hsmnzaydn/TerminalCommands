package net.serkanozaydin.terminalcommands.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import net.serkanozaydin.terminalcommands.model.Command;

/**
 * Created by hsmnzaydn on 13.12.2017.
 */

@Database(entities = {Command.class},version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract CommandDao commandDao();



}
