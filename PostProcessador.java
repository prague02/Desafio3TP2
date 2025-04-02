package model;

import java.util.*;
import java.util.stream.Collectors;

public class PostProcessor {


    public void processPosts(List<Post> posts) {

        List<Post> filteredPosts = posts.stream()
                .filter(post -> post.getTitle().toLowerCase().contains("qui"))
                .collect(Collectors.toList());

        List<Post> sortedPosts = filteredPosts.stream()
                .sorted(Comparator.comparingInt(Post::getId))
                .collect(Collectors.toList());

        System.out.println("Posts filtrados e ordenados:");
        sortedPosts.forEach(System.out::println);

        Map<Integer, Long> postsByUser = sortedPosts.stream()
                .collect(Collectors.groupingBy(Post::getUserId, Collectors.counting()));

        System.out.println("\nContagem de posts por userId:");
        postsByUser.forEach((userId, count) -> System.out.println("User " + userId + ": " + count + " posts"));

        int totalIdSum = sortedPosts.stream()
                .mapToInt(Post::getId)
                .sum();

        System.out.println("\nSoma dos IDs dos posts filtrados: " + totalIdSum);

        List<String> postTitles = sortedPosts.stream()
                .map(Post::getTitle)
                .collect(Collectors.toList());

        System.out.println("\nTítulos dos posts filtrados:");
        postTitles.forEach(System.out::println);
    }
}
