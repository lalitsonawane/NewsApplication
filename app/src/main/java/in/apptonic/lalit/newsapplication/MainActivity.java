package in.apptonic.lalit.newsapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;

import in.apptonic.lalit.newsapplication.model.News;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    List<News> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.initialize(getApplicationContext());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterNews(newsList);

        downloadNews();

    }

    private void downloadNews() {
        AndroidNetworking.get("https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=81aa06e91e5a4f189d1b7a64f07bc373")
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObjectList(News.class, new ParsedRequestListener<List<News>>() {


                    @Override
                    public void onResponse(List<News> response) {

                       

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }
}
