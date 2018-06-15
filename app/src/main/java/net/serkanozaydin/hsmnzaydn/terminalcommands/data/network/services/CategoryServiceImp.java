package net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services;

import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.ApiClient;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.ApiInterface;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.NetworkError;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Category;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.Command;
import net.serkanozaydin.hsmnzaydn.terminalcommands.data.network.services.models.CommonResponse;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class CategoryServiceImp implements CategoryService {

    private ApiInterface apiService;

    @Inject
    public CategoryServiceImp() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void getCategories(String language,final ServiceCallback<List<Category>> listServiceCallback, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiService.getCategory(language).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends List<Category>>>() {
                    @Override
                    public Observable<? extends List<Category>> call(Throwable throwable) {
                        return null;
                    }
                }).subscribe(new Subscriber<List<Category>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                new NetworkError(e).response(commonResponseServiceCallback);

            }

            @Override
            public void onNext(List<Category> listOfCategory) {
                listServiceCallback.onResponse(listOfCategory);

            }
        });
    }

    @Override
    public void getCommandsOfCategory(String categoryId, final ServiceCallback<List<Command>> listServiceCallback, final ServiceCallback<CommonResponse> commonResponseServiceCallback) {
        apiService.getCommandsOfCategory(categoryId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends List<Command>>>() {
                    @Override
                    public Observable<? extends List<Command>> call(Throwable throwable) {
                        return null;
                    }
                }).subscribe(new Subscriber<List<Command>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                new NetworkError(e).response(commonResponseServiceCallback);

            }

            @Override
            public void onNext(List<Command> listOfCommands) {
                listServiceCallback.onResponse(listOfCommands);

            }
        });
    }
}
