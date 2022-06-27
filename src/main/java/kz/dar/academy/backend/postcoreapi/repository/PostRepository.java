package kz.dar.academy.backend.postcoreapi.repository;

import javax.transaction.Transactional;
import kz.dar.academy.backend.postcoreapi.model.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {

  PostEntity findByPostId(String postId);

  @Transactional
  void deleteByPostId(String postId);
}
