package me.nihalismail.sharedprefs;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView myTextView = (TextView) findViewById(R.id.myName);

        SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("DB",MODE_PRIVATE,null);
        String create = "CREATE TABLE IF NOT EXISTS SAMPLE( id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20));";
        sqLiteDatabase.execSQL(create);


        String insert = "INSERT INTO SAMPLE(name) VALUES('Livin');";
        sqLiteDatabase.execSQL(insert);


        String select = "SELECT * FROM SAMPLE;";
        Cursor cursor = sqLiteDatabase.rawQuery(select,null);


        if (cursor.getCount() < 0 || cursor == null){
            myTextView.setText("FIRST_OPEN");
        }else {
            cursor.moveToFirst();
            do{

                myTextView.setText(cursor.getString(1));

            }while (cursor.moveToNext());
        }






    }
}
