package me.nihalismail.permanentdatastorge;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void setText(View view)
    {
        SharedPreferences myPreferences=this.getSharedPreferences("me.nihalismail.permanentdatastorge", Context.MODE_PRIVATE);
        EditText myInputText=(EditText)findViewById(R.id.editText);
        String input=myInputText.getText().toString();
        myPreferences.edit().putString("username",input).apply();
        TextView myTextView=(TextView) findViewById(R.id.textView);
        myTextView.setText(input);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences myPreferences=this.getSharedPreferences("me.nihalismail.permanentdatastorge", Context.MODE_PRIVATE);
        TextView myTextView=(TextView) findViewById(R.id.textView);
        String input=myPreferences.getString("username","empty");
        myTextView.setText(input);
    }
}
