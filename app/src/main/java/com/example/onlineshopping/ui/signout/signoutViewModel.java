package com.example.onlineshopping.ui.signout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class signoutViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public signoutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("hello");

    }

    public LiveData<String> getText() {
        return mText;
    }
}