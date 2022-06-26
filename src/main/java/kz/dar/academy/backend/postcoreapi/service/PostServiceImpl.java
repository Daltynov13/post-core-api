package kz.dar.academy.backend.postcoreapi.service;

import static java.util.UUID.randomUUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kz.dar.academy.backend.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private static final HashMap<String, PostModel> postMap = new HashMap<>();

  static {
    String id = randomUUID().toString();
    String id1 = randomUUID().toString();
    String id2 = randomUUID().toString();
    postMap.put(id,
        PostModel.builder()
            .postId(id)
            .postItem("Пазл")
            .postRecipientId("1")
            .clientId("2")
            .status("FAILED").build());
    postMap.put(id1,
        PostModel.builder()
            .postId(id1)
            .postItem("Мягкая игрушка")
            .postRecipientId("2")
            .clientId("3")
            .status("SUCCESS").build());
    postMap.put(id2,
        PostModel.builder()
            .postId(id2)
            .postItem("Фонарик")
            .postRecipientId("3")
            .clientId("1")
            .status("FAILED").build());
  }

  @Override
  public void createPost(PostModel post) {
    post.setPostId(randomUUID().toString());
    postMap.put(post.getPostId(), post);
  }

  @Override
  public List<PostModel> getAllPosts() {
    return new ArrayList<>(postMap.values());
  }

  @Override
  public PostModel getPostById(String postId) {
    return postMap.get(postId);
  }

  @Override
  public void updatePostById(String postId, PostModel post) {
    post.setPostId(randomUUID().toString());
    postMap.put(postId, post);
  }

  @Override
  public void deletePostById(String postId) {
    postMap.remove(postId);
  }
}
