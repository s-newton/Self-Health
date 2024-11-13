package com.zybooks.graph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Managing Fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        //Weight Info Button fragment manager logic
        Button btnwi = findViewById(R.id.btnWI);
        Button btnchart = findViewById(R.id.btnChart);
        Button btnBmiBmr = findViewById(R.id.lcalbutton);


        btnwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, NumberFragment.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
        //Chart Button fragment manager logic

        btnchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, GraphFragment.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
        btnBmiBmr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, bmiCalculator.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();

            }
        });
    }
}