package com.example.mypython;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
TextView textView,textView01;
Button btn,btn01,btn02;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView=(TextView)findViewById(R.id.textview);
        textView01=(TextView)findViewById(R.id.textview01);
        btn = (Button)findViewById(R.id.btn);
        btn01 = (Button)findViewById(R.id.btn01);
        btn02 = (Button)findViewById(R.id.btn02);
        btn.setBackgroundColor(Color.rgb(138,43,226));
        btn01.setBackgroundColor(Color.rgb(138,43,226));
        btn02.setBackgroundColor(Color.rgb(138,43,226));
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

    }


    public void sendBtn(View view) {
        btn.setText("h5辨識完成");
        btn.setBackgroundColor(Color.rgb(205,92,92));
        Python py=Python.getInstance();
        PyObject pyobj=py.getModule("myscript");
        PyObject obj=pyobj.callAttr("main");
        textView.setText(obj.toString());
    }
    public void sendBtn01(View view) {
        btn01.setText("傳送到python完成");
        btn01.setBackgroundColor(Color.rgb(205,92,92));
        Python py=Python.getInstance();
        PyObject pyobj=py.getModule("myscript");
        int i = 100;
        PyObject array1 = PyObject.fromJava(i);
        PyObject obj=pyobj.callAttr("myFun", array1);
        textView01.setText(obj.toString());
    }

    public void sendBtn02(View view) {
        btn01.setText("清除完成");
        btn01.setBackgroundColor(Color.rgb(205,92,92));
        Python py=Python.getInstance();
        PyObject pyobj=py.getModule("myscript");
        PyObject obj=pyobj.callAttr("myClear");
        btn.setText("-h5檔案載入及辨識-");
        btn01.setText("-java變數傳送python-");
        btn.setBackgroundColor(Color.rgb(138,43,226));
        btn01.setBackgroundColor(Color.rgb(138,43,226));
        textView.setText(obj.toString());
        textView01.setText(obj.toString());
    }
}