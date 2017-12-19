package hsmnzaydn.serkanozaydin.net.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import hsmnzaydn.serkanozaydin.net.model.Command;

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


    @Delete
    void deleteCommand(Command command);
}
