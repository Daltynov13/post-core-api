package kz.dar.academy.backend.postcoreapi.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import javax.validation.Valid;
import kz.dar.academy.backend.postcoreapi.model.PostModel;
import kz.dar.academy.backend.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {


  @Autowired
  private PostService postService;

  @PostMapping
  public ResponseEntity<String> createPost(@Valid @RequestBody PostModel post) {
    postService.createPost(post);
    return new ResponseEntity<>("Successful created", OK);
  }

  @GetMapping("/all")
  public List<PostModel> getAllPosts() {
    return postService.getAllPosts();
  }

  @GetMapping("/{postId}")
  public PostModel getPost(@PathVariable String postId) {
    return postService.getPostById(postId);
  }

  @PutMapping("/{postId}")
  public ResponseEntity<String> updatePost(@PathVariable String postId,
      @Valid @RequestBody PostModel post) {
    postService.updatePostById(postId, post);
    return new ResponseEntity<>("Successful updated", OK);

  }

  @DeleteMapping("/{postId}")
  public ResponseEntity<String> deletePost(@PathVariable String postId) {
    postService.deletePostById(postId);
    return new ResponseEntity<>("Successful deleted", OK);
  }
}