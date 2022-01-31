package edowl.Repository;

import edowl.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends JpaRepository<Post, Long> {

    void deletePostById(Long id);

    Optional<Post> findPostById(Long id);

    List<Post> findAllByHiddenOrderByGeneratedDateDesc(boolean hidden);

    List<Post> findAllByOrderByGeneratedDateDesc();

    List<Post> findByTitleContainsAndHiddenEqualsOrderByGeneratedDateDesc(String title, boolean hidden);
    List<Post> findByTitleContainsOrderByGeneratedDateDesc(String title);
}