package com.example.lab4.ui.green;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GreenViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GreenViewModel() {
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