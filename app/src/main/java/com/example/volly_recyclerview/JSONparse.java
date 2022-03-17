package com.example.volly_recyclerview;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONparse {
    public static String[] names;
    public static String[] gender;
    private JSONObject jsonObject;
    List<MyListData> myListDataList;
    private String json;

    public  JSONparse(String json) {
        this.json = json;
    }

    protected void JSONparse() {
        try {
            jsonObject = new JSONObject(json);
            Log.d("ok", "try in jsonObject {  ");
            
            JSONArray jsonArray = jsonObject.getJSONArray("users");
            Log.d("ok", "try in jsonArray [ ");
            
            names = new String[jsonObject.length()];
            gender = new String[jsonObject.length()];
            Log.d("ok", "try jsonObject in set lenght name and gender");
            
            myListDataList = new ArrayList<>();
            
            for (int i = 0; i <jsonArray.length(); i++) {
                Log.d("ok", "try jsonArray.length() = " + jsonArray.length());

                MyListData myList = new MyListData();
                
                JSONObject object = jsonArray.getJSONObject(i);
                Log.d("ok", "try JSONObject in Data  { = " + object);
                
                myList.setName("Name : " + object.getString("name"));
                myList.setGender("Gender : " + object.getString("gender"));
                Log.d("ok", "try  jsonObject in Data set name and gender " + myList.getName()+" " +myList.getGender());
                
                myListDataList.add(myList);
                Log.d("ok", "myListDataList in ADD DATA " );
            }

        } catch (JSONException e) {
            Log.d("ok", "JSONparse.class  not ok");
            e.printStackTrace();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
    ArrayList<MyListData> getLenghtOnArray() {
        return (ArrayList<MyListData>) myListDataList;
    }

}
