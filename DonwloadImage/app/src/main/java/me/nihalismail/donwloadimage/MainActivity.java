package me.nihalismail.donwloadimage;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {


    String imageURL = "http://static4.techinsider.io/image/56bce8632e5265ba008b6aeb/deadpool-has-two-end-credits-scenes--heres-what-they-mean-for-the-sequel.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DownloadImageTask().execute();
    }


    private class DownloadImageTask extends AsyncTask<Void,Void,Bitmap>{

        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setMessage("Downloading...");
            progressDialog.show();

        }

        @Override
        protected Bitmap doInBackground(Void... voids) {

            try {
                URL url = new URL(imageURL);

                URLConnection urlConnection = url.openConnection();

                HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;

                InputStream inputStream = httpURLConnection.getInputStream();

                Bitmap downloadedImage = (Bitmap) BitmapFactory.decodeStream(inputStream);

                return downloadedImage;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(Bitmap image) {
            super.onPostExecute(image);

            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            imageView.setImageBitmap(image);

            progressDialog.cancel();

        }
    }


}
