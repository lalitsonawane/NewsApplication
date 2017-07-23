package in.apptonic.lalit.newsapplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lalitkumarsonawane on 23/07/17.
 */

public class Article {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Date publishedAt;

    public Article(){

    }

    Article(JSONObject jsonObject) {
        try {
            author = (jsonObject.get("author").toString().equals("null")) ? null : (String) jsonObject.get("author");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            title = (String) jsonObject.get("title");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            description = (jsonObject.get("description").toString().equals("null")) ? null : (String) jsonObject.get("description");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            url = (String) jsonObject.get("url");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            urlToImage = (String) jsonObject.get("urlToImage");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String publish = null;
        try {
            publish = (jsonObject.get("publishedAt").toString().equals("null")) ? null : (String) jsonObject.get("publishedAt");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (publish != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            try {
                publishedAt = df.parse(publish);
            } catch (ParseException ex) {
                publishedAt = null;
            }
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
}
