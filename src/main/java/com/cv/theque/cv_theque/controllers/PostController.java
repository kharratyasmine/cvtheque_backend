package com.cv.theque.cv_theque.controllers;

import com.cv.theque.cv_theque.models.Post;
import com.cv.theque.cv_theque.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/post")
@CrossOrigin("*")
public class PostController {
    private final com.cv.theque.cv_theque.services.PostService PostService;

    public PostController(PostService PostService) {
        this.PostService = PostService;
    }

    @GetMapping()
    public List<Post> findAllPosts() {
        return PostService.findAllPosts();
    }
    @GetMapping("{idCandidature}/{idCandidate}")
    public Post findPost(@PathVariable Long idCandidature, @PathVariable Long idCandidate) {
        return PostService.findPostByDetails(idCandidature, idCandidate);
    }
    @GetMapping("/nbrcandidaturebypost")
    public  List<Object> countCandidature() {
        return PostService.findcandidaturebypost();
    }
    @PostMapping()
    public Post addPost(@RequestBody Post Post) {
        return PostService.addPost(Post);
    }
    @PutMapping("{id}")
    public Post putPost(@RequestBody Post Post, @PathVariable Long id) {
        return PostService.putPost(Post, id);
    }
    @DeleteMapping("{id}")
    public Post putPost(@PathVariable Long id) {
        return PostService.deletePost(id);
    }
    @GetMapping("{id}")
    public Post findPostById(@PathVariable Long id) {
        return PostService.findPostById(id);
    }
}
