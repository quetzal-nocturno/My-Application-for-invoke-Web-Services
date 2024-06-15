package com.example.myapplicationforconsumewebservicerestful;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readWS();
            }
        });
    }

    private void readWS() {
        // Here go the URL of your API
        String url = "";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray dataArray = jsonObject.getJSONArray("data");
                    List<User> userList = new ArrayList<>();
                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject userJson = dataArray.getJSONObject(i);
                        User user = new User(
                                userJson.getInt("id"),
                                userJson.getString("nombre"),
                                userJson.getString("apellido_paterno"),
                                userJson.getString("apellido_materno"),
                                userJson.getString("email"),
                                userJson.getString("genero"),
                                userJson.getString("fecha_nacimiento"),
                                userJson.getInt("edad"),
                                userJson.getString("email_verified_at"),
                                userJson.getString("created_at"),
                                userJson.getString("updated_at")
                        );
                        userList.add(user);
                    }

                    UserAdapter adapter = new UserAdapter(MainActivity.this, userList);
                    listView.setAdapter(adapter);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("Error", volleyError.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(request);
    }
}