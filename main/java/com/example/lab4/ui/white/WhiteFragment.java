package com.example.lab4.ui.white;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.lab4.R;

public class WhiteFragment extends Fragment {

    private WhiteViewModel whiteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        whiteViewModel =
                ViewModelProviders.of(this).get(WhiteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_white, container, false);

        final TextView textView = root.findViewById(R.id.text_white);
        whiteViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Button b = (Button)root.findViewById(R.id.button_white);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                EditText editText_blue = (EditText)view.getRootView().findViewById(R.id.editText_white);

                Editable text = editText_blue.getText();

                if (text.length()>0) {
                    whiteViewModel.setmText(text.toString());
                    editText_blue.setText("");
                }
            }
        });
        return root;
    }

}