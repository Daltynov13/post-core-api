package kz.dar.academy.backend.postcoreapi.service;

import java.util.List;
import kz.dar.academy.backend.postcoreapi.model.PostModel;

public interface PostService {

  void createPost(PostModel post);

  List<PostModel> getAllPosts();

  PostModel getPostById(String postId);

  void updatePostById(String postId, PostModel post);

  void deletePostById(String postId);
}
