package com.example.lab4.ui.blue;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BlueViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BlueViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setmText(String text){
        mText.setValue(mText.getValue()+text+"\r\n");
    }
}