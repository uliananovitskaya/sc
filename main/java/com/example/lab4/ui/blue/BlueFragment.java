package com.example.lab4.ui.blue;

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

public class BlueFragment extends Fragment {

    private BlueViewModel blueViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        blueViewModel =
                ViewModelProviders.of(this).get(BlueViewModel.class);
        View root = inflater.inflate(R.layout.fragment_blue, container, false);
        final TextView textView = root.findViewById(R.id.text_blue);
        blueViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        Button b = (Button)root.findViewById(R.id.button_blue);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                EditText editText_blue = (EditText)view.getRootView().findViewById(R.id.editText_blue);

                Editable text = editText_blue.getText();

                if (text.length()>0) {
                    blueViewModel.setmText(text.toString());
                    editText_blue.setText("");
                }
            }
        });

        return root;
    }
}