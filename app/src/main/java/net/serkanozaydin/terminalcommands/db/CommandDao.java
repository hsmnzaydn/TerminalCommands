package net.serkanozaydin.terminalcommands.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import net.serkanozaydin.terminalcommands.model.Command;

import java.util.List;

/**
 * Created by hsmnzaydn on 13.12.2017.
 */

@Dao
public interface CommandDao {


    @Query("SELECT * FROM command")
    List<Command> getAllCommands();

    @Insert
    void insertAll(Command... commands);

}
