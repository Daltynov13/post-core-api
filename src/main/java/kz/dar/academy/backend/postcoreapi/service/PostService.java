package kz.dar.academy.backend.postcoreapi.service;

import java.util.List;
import kz.dar.academy.backend.postcoreapi.model.PostRequest;
import kz.dar.academy.backend.postcoreapi.model.PostResponse;

public interface PostService {

  PostResponse createPost(PostRequest post);

  List<PostResponse> getAllPosts();

  PostResponse getPostById(String postId);

  void updatePostById(String postId, PostRequest post);

  void deletePostById(String postId);
}
