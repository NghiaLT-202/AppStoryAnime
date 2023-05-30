package com.example.appstory88.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;


//import dagger.hilt.android.lifecycle.HiltViewModel;
//import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {
    //    // Thu thaapj tat ca context hien tai dang su dung de huy bo, tranh viec memoryleak
    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseViewModel() {
    }

    //
    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
