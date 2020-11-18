package com.example.lab4.ui.orange;

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
import com.example.lab4.ui.orange.OrangeViewModel;

public class OrangeFragment extends Fragment {

    private OrangeViewModel orangeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        orangeViewModel =
                ViewModelProviders.of(this).get(OrangeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_orange, container, false);
        final TextView textView = root.findViewById(R.id.text_orange);
        orangeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Button b = (Button)root.findViewById(R.id.button_orange);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                EditText editText_blue = (EditText)view.getRootView().findViewById(R.id.editText_orange);

                Editable text = editText_blue.getText();

                if (text.length()>0) {
                    orangeViewModel.setmText(text.toString());
                    editText_blue.setText("");
                }
            }
        });

        return root;
    }

}