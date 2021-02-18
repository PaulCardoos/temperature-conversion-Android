package com.example.android.tempconversion;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculationFragment extends Fragment {

    private Button convertButton;
    private EditText numberText;
    private TextView displayText;
    private Context context;

    public CalculationFragment() { }

    public static CalculationFragment newInstance(String param1, String param2) {
        CalculationFragment fragment = new CalculationFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =  inflater.inflate(R.layout.fragment_calculation, container, false);
       convertButton =  v.findViewById(R.id.convert_C_btn);
       numberText = v.findViewById(R.id.temp_C_input_id);
       displayText = v.findViewById(R.id.conversion_txt);
       displayText.setText("");
       convertButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               double num;
               String txt = numberText.getText().toString();
               if(txt.isEmpty()){
                   displayText.setText("");
                   return;
               }
               num = Double.parseDouble(txt);
               txt = convertToFarh(num);
               displayText.setText(txt);
               }
       });
       return v;
    }

    private String convertToFarh(double num) {
        double farh;
        farh = num * (9.0/5.0) + 32;
        String far = Double.toString(farh);
        return String.format("%.02f", farh);
    }
}