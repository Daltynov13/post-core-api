package kz.dar.academy.backend.postcoreapi.service;

import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;
import static org.modelmapper.convention.MatchingStrategies.STRICT;

import java.util.List;
import kz.dar.academy.backend.postcoreapi.model.PostEntity;
import kz.dar.academy.backend.postcoreapi.model.PostRequest;
import kz.dar.academy.backend.postcoreapi.model.PostResponse;
import kz.dar.academy.backend.postcoreapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  @Autowired
  private PostRepository postRepository;

  static ModelMapper modelMapper = new ModelMapper();

  static {
    modelMapper.getConfiguration().setMatchingStrategy(STRICT);
  }

  public PostResponse createPost(PostRequest post) {
    post.setPostId(randomUUID().toString());
    PostEntity entity = modelMapper.map(post, PostEntity.class);
    postRepository.save(entity);
    return modelMapper.map(entity, PostResponse.class);
  }

  @Override
  public List<PostResponse> getAllPosts() {
    return stream(postRepository.findAll().spliterator(), false)
        .map(post -> modelMapper.map(post, PostResponse.class))
        .collect(toList());
  }

  @Override
  public PostResponse getPostById(String postId) {
    return modelMapper
        .map(postRepository.findByPostId(postId), PostResponse.class);
  }

  @Override
  public void updatePostById(String postId, PostRequest post) {
    PostEntity dbEntity = postRepository.findByPostId(postId);

    PostEntity entity = modelMapper.map(post, PostEntity.class);
    entity.setId(dbEntity.getId());

    postRepository.save(entity);
  }

  @Override
  public void deletePostById(String postId) {
    postRepository.deleteByPostId(postId);
  }
}
