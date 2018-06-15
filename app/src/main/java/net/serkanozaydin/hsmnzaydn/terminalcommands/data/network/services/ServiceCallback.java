package net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services;

/**
 * Created by hsmnzaydn on 04/05/2017.
 */

public interface ServiceCallback<T> {

    void onResponse(T response);

    void onError(String message);
}
