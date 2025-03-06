package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double x,num;
    TextView tx;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp=findViewById(R.id.sp);
        et=findViewById(R.id.et);
        tx=findViewById(R.id.tx);
        String [] items = {"$","€","₪"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,items);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String st=parent.getItemAtPosition(position).toString();
                if(st.equals("$"))
                    x=1;
                if(st.equals("€"))
                    x=2;
                if(st.equals("₪"))
                    x=3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void ch(View view) {
        num=Integer.parseInt(et.getText().toString());
        if(x==1)
            num=num/3.62;
        if(x==2)
            num=num/3.8;
        String fr=String.format("%.2f",num);
        tx.setText(fr);
    }

    public void del(View view) {
        et.setText("");
        tx.setText("");
    }
}