package com.example.routeoramaserver.controllers.place.post.model;

import com.example.routeoramaserver.models.Post;

import java.util.List;

public interface IPostModel {
    Post ValidatePost(Post post);
    List<String> GetTags(Post post);
}
