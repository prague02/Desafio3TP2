package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class PostService {

    public List<Post> convertJsonToPostList(String jsonResponse) {
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, new TypeToken<List<Post>>(){}.getType());
    }
}
