package com.example.json_sample1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class MainActivity extends AppCompatActivity {
    TextView textView;
    String strJson = "{ \"Employees\" :[{\"ID\":\"01\",\"Name\":\"kabilan\",\"Salary\":\"5000\"},"
            + "{\"ID\":\"02\",\"Name\":\"mugilan\",\"Salary\":\"6000\"},"+"{\"ID\":\"03\",\"Name\":\"vinay\",\"Salary\":\"7000\"}] }";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);


        StringBuilder data = new StringBuilder();
        try
        {
            JSONObject jsonRootObject = new JSONObject(strJson);
            JSONArray ja = jsonRootObject.optJSONArray("Employees");

            for (int i = 0; i < ja.length(); i++)
            {
                JSONObject jsonObject =ja.getJSONObject(i);
                int id = Integer.parseInt(jsonObject.optString("ID"));
                String name = jsonObject.optString("Name");
                float salary = Float.parseFloat(jsonObject.optString("Salary"));
                data.append("Employee ").append(i).append(" : \n ID= ")
                        .append(id).append(" \n " + "Name= ")
                        .append(name).append(" \n Salary= ")
                        .append(salary).append(" \n\n\n");
            }
            textView.setText(data.toString());
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}