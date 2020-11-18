package com.example.lab4.ui.violet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VioletViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VioletViewModel() {
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