package com.example.android.tempconversion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FarenheitFragment extends Fragment {
    private Button convertButton;
    private EditText farenheitText;
    private TextView displayText;

    public FarenheitFragment() {
        // Required empty public constructor
    }

    public static FarenheitFragment newInstance(String param1, String param2) {
        FarenheitFragment fragment = new FarenheitFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_farenheit, container, false);
        convertButton = v.findViewById(R.id.button_farenheit_convert);
        farenheitText = v.findViewById(R.id.conversion_F_input_txt);
        displayText = v.findViewById(R.id.txtView_farenheit_display);
        displayText.setText("");

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num;
                String txt = farenheitText.getText().toString();
                if(txt.isEmpty()){
                    displayText.setText("");
                    return;
                }
                num  = Double.parseDouble(txt);
                txt = convertToCelcius(num);
                displayText.setText(txt);
            }
        });
        return v;
    }

    private String convertToCelcius(double num) {
        double celc;
        String c;
        celc = (num - 32) * (5.0/9.0);
        c = Double.toString(celc);
        return String.format("%.02f", celc);
    }
}