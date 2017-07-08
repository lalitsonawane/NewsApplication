package in.apptonic.lalit.newsapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import in.apptonic.lalit.newsapplication.model.News;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    List<String> newsList = new ArrayList<String>();
    AdapterNews adapterNews;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GsonBuilder gsonbuilder = new GsonBuilder();
        gsonbuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonbuilder.create();

        AndroidNetworking.initialize(getApplicationContext());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterNews();
        recyclerView.setAdapter(adapter);
        downloadNews();
    }

    private void downloadNews() {

        AndroidNetworking.get("https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=81aa06e91e5a4f189d1b7a64f07bc373")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        List<News> news = Arrays.asList(gson.fromJson(String.valueOf(response), News[].class));

                        for (int i = 0; i < response.length(); i ++){

                            try {
                                newsList.add(response.getJSONObject(i).getString("title"));
                                newsList.add(response.getJSONObject(i).getString("description"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        newsList.add("");

                        adapterNews.updateNewsList(news);



                        //TODO How to convert above gson values n String so that i can send them in adapter for recycler view
                    }

                    @Override
                    public void onError(ANError anError) {


                    }
                });


    }
}
