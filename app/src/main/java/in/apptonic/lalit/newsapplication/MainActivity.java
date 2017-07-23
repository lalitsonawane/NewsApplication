package in.apptonic.lalit.newsapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private Article[] articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                        JSONObject jsonObject = new JSONObject();

                        try {
                            JSONArray array = jsonObject.getJSONArray("articles");
                            articles = new Article[array.length()];

                            for (int i = 0; i < array.length(); i++) {
                                articles[i] = new Article(array.getJSONObject(i));


                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        //TODO How to convert above gson values n String so that i can send them in adapter for recycler view
                    }



                    @Override
                    public void onError(ANError anError) {


                    }
                });



    }

}
