package me.nihalismail.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertUSD(View view)
    {
        EditText field=(EditText)findViewById(R.id.editText);
        String enteredInput= String.valueOf(field.getText());
        int usd=Integer.parseInt(enteredInput);
        usd=usd*65;
        Toast.makeText(MainActivity.this,usd+"", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
