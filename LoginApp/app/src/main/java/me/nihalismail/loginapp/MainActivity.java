package me.nihalismail.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {

        EditText usernameEditText = (EditText) findViewById(R.id.username);
        EditText passwordEditText = (EditText) findViewById(R.id.password);

        String uname = usernameEditText.getText().toString();
        String pass = passwordEditText.getText().toString();


        if (uname.equals("livin") && pass.equals("1234")) {
            Toast.makeText(MainActivity.this, "Welcome " + uname, Toast.LENGTH_SHORT).show();
            Intent myIntent=new Intent(this,Main2Activity.class);
            startActivity(myIntent);
            finish();
        }
        else
            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();

    }
}
