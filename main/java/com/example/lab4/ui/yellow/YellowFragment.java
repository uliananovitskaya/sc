package com.example.lab4.ui.yellow;

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
import com.example.lab4.ui.yellow.YellowViewModel;

public class YellowFragment extends Fragment {

    private YellowViewModel yellowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        yellowViewModel =
                ViewModelProviders.of(this).get(YellowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_yellow, container, false);
        final TextView textView = root.findViewById(R.id.text_yellow);
        yellowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Button b = (Button)root.findViewById(R.id.button_yellow);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                EditText editText_blue = (EditText)view.getRootView().findViewById(R.id.editText_yellow);

                Editable text = editText_blue.getText();

                if (text.length()>0) {
                    yellowViewModel.setmText(text.toString());
                    editText_blue.setText("");
                }
            }
        });

        return root;
    }

}