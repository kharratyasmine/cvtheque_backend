package com.cv.theque.cv_theque.services;

import com.cv.theque.cv_theque.models.Post;
import com.cv.theque.cv_theque.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final com.cv.theque.cv_theque.repositories.PostRepository PostRepository;
    public PostService(PostRepository PostRepository) {
        this.PostRepository = PostRepository;
    }
    public List<Post> findAllPosts() {
        return PostRepository.findAllByDeletedIsFalse();
    }
    public Post findPostByDetails(Long idCandidature, Long idCandidate) {
        return PostRepository.findPostByCandidatureId(idCandidature, idCandidate);
    }
    public  List<Object>  findcandidaturebypost() {
        return PostRepository.findcandidaturebypost() ;
    }
    public Post putPost(Post Post, Long id) {
        Post.setId_post(id);
        return PostRepository.save(Post);
    }
    public Post deletePost(Long id) {
        Post Post = findPostById(id);
        Post.setDeleted(true);
        return putPost(Post, id);
    }
    public Post addPost(Post post) {
        return PostRepository.save(post);
    }
    public Post findPostById(Long id) {
        return PostRepository.findById(id).get();
    }
}
