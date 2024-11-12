package com.zybooks.graph;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**/
public class TextBmrBmi extends Fragment {
    private TextView text1, text2;
    private String concat;
    private StringBuilder sb = new StringBuilder();
    private double bmrAL;
    private double bmi;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text_bmr_bmi, container, false);
        text1 = view.findViewById(R.id.textView3);
        text2 = view.findViewById(R.id.textView2);


               Double a = getArguments().getDouble("br1");
                String b = a.toString();
                sb.append("BMR: "+ b);
                sb.append(" cal. ");

                Double a1 = getArguments().getDouble("abmi");
                String b1 = a1.toString();
                sb.append("BMI: "+ b1 + " lb/in^2");

        concat = sb.toString();
        text1.setText(concat);
        sb.setLength(0);
        return view;
    }
}