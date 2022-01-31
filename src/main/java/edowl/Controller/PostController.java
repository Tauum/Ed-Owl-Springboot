package edowl.Controller;


import edowl.Model.Post;
import edowl.Model.Quiz;
import edowl.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts()
    {
        List<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/allOrderByDate")
    public ResponseEntity<List<Post>> getAllPostsOrderedByDate()
    {
        List<Post> posts = postService.findAllOrderByDate();
        return new ResponseEntity<>(posts, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/newestOrder-hideHidden")
    public ResponseEntity<List<Post>> getAllQuizOrderedByDateAndHideHidden()
    {
        List<Post> posts = postService.findAllOrderByGeneratedDateDescAndNotHidden();
        return new ResponseEntity<>(posts, HttpStatus.OK); //ok is 200 status code
    }


    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable("id") Long id)
    {
        Post post = postService.findPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK); //ok is 200 status code
    }

    @PostMapping("/getPostsContainingTitle")
    public ResponseEntity<List<Post>> getPostsContainingTitle(@RequestBody Post post)
    {
        List<Post> posts = postService.findAllContainingTitle(post.getTitle());
        return new ResponseEntity<>(posts, HttpStatus.OK); //ok is 200 status code
    }

    @PostMapping("/add")
    public ResponseEntity<Post> addPost(@RequestBody Post post)
    {
        Post newPost = postService.addPost(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED); //ok is 200 status code
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updateHangman(@PathVariable("id") Long id, @RequestBody Post post)
    {
        Post attempt = postService.findPostById(id);
        if (attempt != null){
            attempt.setTitle(post.title);
            attempt.setSummary(post.summary);
            attempt.setAuthor(post.author);
            attempt.setVideo(post.video);
            attempt.setContent(post.content);
            attempt.setHidden(post.hidden);
            Post updatedPost = postService.updatePost(attempt);
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);  //ok is 200 status code
        }
        return new ResponseEntity<>(attempt, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long id)
    {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
