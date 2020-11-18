package com.example.lab4.ui.yellow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class YellowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public YellowViewModel() {
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