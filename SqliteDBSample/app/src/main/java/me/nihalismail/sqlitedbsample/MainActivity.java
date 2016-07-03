package me.nihalismail.sqlitedbsample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void add(View view) {

        EditText editText = (EditText)findViewById(R.id.editText);
        String expense = editText.getText().toString();

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("ExpensesDB",MODE_PRIVATE,null);

        String create = "CREATE TABLE IF NOT EXISTS Expenses(ID INTEGER PRIMARY KEY AUTOINCREMENT, ExpenseName VARCHAR(20));";
        sqLiteDatabase.execSQL(create);

        String insert = "INSERT INTO Expenses(ExpenseName) values('"+expense+"');";
        sqLiteDatabase.execSQL(insert);

    }

    public void display(View view) {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("ExpensesDB",MODE_PRIVATE,null);
        String select="Select * from Expenses;";
        Cursor cursor = sqLiteDatabase.rawQuery(select,null);
        TextView textView = (TextView) findViewById(R.id.textView);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                String expense = cursor.getString(1);
                textView.setText(textView.getText()+"\n"+expense);
            }while (cursor.moveToNext());
        }

    }
}
