package com.example.routeoramaserver.controllers.place.post;
import com.example.routeoramaserver.controllers.place.post.rmi.IPostClient;
import com.example.routeoramaserver.controllers.place.post.rmi.PostClient;
import com.example.routeoramaserver.models.Post;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    private IPostClient postClient;

    public PostController() {
        postClient = new PostClient();
        postClient.Start();
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Post NewPost(@RequestBody Post post){
        return postClient.NewPost(post);
    }

    @PostMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public boolean DeletePost(@RequestBody int postID){
        return postClient.DeletePost(postID);
    }
    @PostMapping(value = "/getpost", consumes = "application/json", produces = "application/json")
    public Post GetPost(@RequestBody int postID){
        return postClient.GetPost(postID);
    }
}
