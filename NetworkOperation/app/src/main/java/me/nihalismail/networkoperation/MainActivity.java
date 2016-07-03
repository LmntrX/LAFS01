package me.nihalismail.networkoperation;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String imageUrl = "http://www.newsread.in/wp-content/uploads/2016/06/Car-7.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isConnected())
            new downloadTask().execute(imageUrl);
        else
            Toast.makeText(MainActivity.this, "Not Connected", Toast.LENGTH_SHORT).show();
    }

    public boolean isConnected() {
        Boolean status;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        status = networkInfo!=null &&  networkInfo.isConnected();
        return status;
    }

    private class downloadTask extends AsyncTask<String,Integer,Bitmap>{

        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Downloading...");
            progressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                InputStream imageStream = httpURLConnection.getInputStream();
                Bitmap downloadedImage = BitmapFactory.decodeStream(imageStream);
                return downloadedImage;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap downloadedImage) {
            super.onPostExecute(downloadedImage);

            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            imageView.setImageBitmap(downloadedImage);

            progressDialog.cancel();
        }
    }

}
