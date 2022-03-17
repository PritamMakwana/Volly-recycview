package com.example.volly_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Adapater adapater;
    ArrayList<MyListData> mList;
    RequestQueue  requestQueue;
    StringRequest stringRequest;
    RecyclerView rv;
    public final static String JSON_URL = "https://run.mocky.io/v3/879ab71c-b64b-43e1-8fe0-25154a821eeb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         rv = findViewById(R.id.Homerecyclerview);
         rv.setLayoutManager(new LinearLayoutManager(this));
         setDataUsedVolly();

    }

    private void setDataUsedVolly() {
        requestQueue = Volley.newRequestQueue(this);
        stringRequest = new StringRequest(Request.Method.GET,JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONparse jp = new JSONparse(response);
                Log.d("ok"," ok response \n"+response);

                jp.JSONparse();
                mList = jp.getLenghtOnArray();
                Log.d("ok","set in data ok " );

                adapater = new Adapater(mList);
                rv.setHasFixedSize(true);
                rv.setAdapter(adapater);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                Log.d("ok","StringRequest error");
            }
        });


        requestQueue.add(stringRequest);

    }

}