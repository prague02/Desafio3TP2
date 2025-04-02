package model;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            ApiService apiService = new ApiService();
            String jsonResponse = apiService.fetchPosts();

            PostService postService = new PostService();
            List<Post> posts = postService.convertJsonToPostList(jsonResponse);

            PostProcessor postProcessor = new PostProcessor();
            postProcessor.processPosts(posts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

