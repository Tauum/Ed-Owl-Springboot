package edowl.Service;

import edowl.Exception.EntityNotFoundException;
import edowl.Model.Post;
import edowl.Repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostService {
    private final PostRepo postRepo;

    @Autowired
    public PostService(PostRepo postRepository) {
        this.postRepo = postRepository;
    }

    public Post addPost(Post post) { return postRepo.save(post); }

    public List<Post> findAll(){ return postRepo.findAll(); }

    public Post updatePost(Post post){ return postRepo.save(post); }

    //query method (auto generates method in spring back-backend)
    @Transactional
    public void deletePost(Long id) { postRepo.deletePostById(id);}

//    public void deletePost(Long id) {
//        posts.removeIf
//    }

    public Post findPostById(Long id)
    {
        return postRepo.findPostById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not foud with id: " + id)) ;
    }

    public List<Post> findAllOrderByDate(){
        return postRepo.findAllByOrderByGeneratedDateDesc();
    }

    public List<Post> findAllContainingTitle(String title)
    {
//        return postRepo.findByTitleContainsOrderByGeneratedDateDesc(title);
        return postRepo.findByTitleContainsAndHiddenEqualsOrderByGeneratedDateDesc(title, false);

    }

    public List<Post> findAllOrderByGeneratedDateDescAndNotHidden() {

        return postRepo.findAllByHiddenOrderByGeneratedDateDesc(false);
    }
}

