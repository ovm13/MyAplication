package com.example.myapplication;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends Activity {
    TextView tvname;
    private ProgressDialog load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tvname = findViewById(R.id.tvname);
        GetUser getUser = new GetUser();
        getUser.execute();
    }

    private class GetUser extends AsyncTask<Void, Void, User> {

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MainActivity.this, "Aguarde...", "Buscando usuário...");

        }

        @Override
        protected User doInBackground(Void... voids) {
            UserUtils userUtils = new UserUtils();
            return userUtils.getUser();
        }

        @Override
        protected void onPostExecute(User user){
            tvname.setText(user.getName());
            load.dismiss();
        }
    }
}