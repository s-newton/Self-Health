package com.zybooks.graph;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;


public class bmiCalculator extends Fragment {
    private ImageView logo;
    private EditText poundsvalue, feetsvalue, bmiresult, aage;
    private CheckBox female, masculine
            ,sed,sal,mal,al,va;
    private Button bmi, idealweight, erase;
    private Double maleBmr, womanBmr, maleABmr,womanABmr, adultBmi;
    CalcBmrBmi cbb = new CalcBmrBmi();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi_calculator,container,false);
        poundsvalue = view.findViewById(R.id.weightvalue);
        feetsvalue = view.findViewById(R.id.heightvalue);
        aage = view.findViewById(R.id.AGEvalue);
        bmiresult = view.findViewById(R.id.etResult);

        bmi = view.findViewById(R.id.buttonbmi);
        idealweight = view.findViewById(R.id.buttonideal);
        erase = view.findViewById(R.id.buttonerase);

        female = view.findViewById(R.id.fem);
        masculine = view.findViewById(R.id.mas);
        sed = view.findViewById(R.id.sed);
        sal = view.findViewById(R.id.sal);
        mal = view.findViewById(R.id.mal);
        al = view.findViewById(R.id.al);
        va = view.findViewById(R.id.va);



        bmi.setOnClickListener(v-> {
            Integer height=0, age=0;
            Double weight= (double) 0;
            String pv = poundsvalue.getText().toString();
            String fs = feetsvalue.getText().toString();
            String ag = aage.getText().toString();
            poundsvalue.setText("");
            feetsvalue.setText("");
            aage.setText("");
            if (female.isChecked()) {
                try {
                    weight = Double.parseDouble(pv);
                    height = Integer.parseInt(fs);
                    age = Integer.parseInt(ag);
                } catch (Exception e) {
                    Log.d("BMI button", "Not number somehow");
                }
                womanBmr = cbb.wbmrC(weight, height, age);
                adultBmi = cbb.bmiC(weight, height);
                if (sed.isChecked()) {
                    womanABmr = Math.ceil(womanBmr * 1.2);
                } else if (sal.isChecked()) {
                    womanABmr = Math.ceil(womanBmr * 1.375);
                } else if (mal.isChecked()) {
                    womanABmr = Math.ceil(womanBmr * 1.55);
                } else if (al.isChecked()) {
                    womanABmr = Math.ceil(womanBmr * 1.725);
                } else {
                    womanABmr = Math.ceil(womanBmr * 1.9);
                }


                Bundle bundle = new Bundle();
                bundle.putDouble("br1", womanABmr);
                bundle.putDouble("abmi", adultBmi);

                TextBmrBmi textBmrBmi = new TextBmrBmi();
                textBmrBmi.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, textBmrBmi).commit();
            }
            else if (masculine.isChecked()){
                try {
                    weight = Double.parseDouble(pv);
                    height = Integer.parseInt(fs);
                    age = Integer.parseInt(ag);
                } catch (Exception e) {
                    Log.d("BMI button", "Not number somehow");
                }
                maleBmr = cbb.mbmrC(weight, height, age);
                adultBmi = cbb.bmiC(weight, height);
                String debug = maleBmr.toString();
                Log.d("Works?", debug);
                if (sed.isChecked()) {
                    maleABmr = Math.ceil(maleBmr * 1.2);
                } else if (sal.isChecked()) {
                    maleABmr = Math.ceil(maleBmr * 1.375);
                } else if (mal.isChecked()) {
                    maleABmr = Math.ceil(maleBmr * 1.55);
                } else if (al.isChecked()) {
                    maleABmr = Math.ceil(maleBmr * 1.725);
                } else {
                    maleABmr = Math.ceil(maleBmr * 1.9);
                }

                Bundle bundle = new Bundle();
                bundle.putDouble("br1", maleABmr);
                bundle.putDouble("abmi", adultBmi);

                TextBmrBmi textBmrBmi = new TextBmrBmi();
                textBmrBmi.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, textBmrBmi).commit();
            }
        });
            if(female.isChecked()) {
                female.toggle();
            }
            if(masculine.isChecked()){
                masculine.toggle();
            }
            if(sed.isChecked()){
                sed.toggle();
            }
            if(sal.isChecked()) {
                sal.toggle();
            }

            if(mal.isChecked()){
                mal.toggle();
            }
            if(al.isChecked()){
                al.toggle();
            }
            if(va.isChecked()){
                va.toggle();
            }


        return view;
    }
}