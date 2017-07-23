package in.apptonic.lalit.newsapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalitkumarsonawane on 01/07/17.
 */

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.NewsViewHolder> {

    List<Article> articles = new ArrayList<>();

   /**
   public void updateNewsList(List<News> list){

        this.newsAdapterList = list;
        notifyDataSetChanged();

    }
   **/
    public AdapterNews() {

    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        holder.newsTitle.setText(articles.get(position).getTitle());
        holder.newsDesc.setText(articles.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle;
        TextView newsDesc;

        public NewsViewHolder(View itemView) {
            super(itemView);

            newsTitle = itemView.findViewById(R.id.title);
            newsDesc = itemView.findViewById(R.id.description);

        }
    }
}
