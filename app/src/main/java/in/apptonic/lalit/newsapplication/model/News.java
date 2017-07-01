package in.apptonic.lalit.newsapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lalitkumarsonawane on 01/07/17.
 */
public class News {
    @SerializedName("title")
    String title;
    @SerializedName("description")
    String description;

    public News(String title, String description) {
        this.title = title;
        this.description = description;
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
}
