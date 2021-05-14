package com.example.routeoramaserver.controllers.place.post;

import com.cloudmersive.client.ScanApi;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import com.cloudmersive.client.model.VirusScanResult;
import com.example.routeoramaserver.controllers.place.post.rmi.IPostClient;
import com.example.routeoramaserver.controllers.place.post.rmi.PostClient;
import com.example.routeoramaserver.models.Post;
import com.example.routeoramaserver.models.PostContainer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/post")
public class PostController {
    private IPostClient postClient;


    public PostController() {
        postClient = new PostClient();
        postClient.Start();
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Post NewPost(@RequestBody Post post) {
        List<String> tags;
        tags = extractTags(post.getContent());
        if (!(post.getPhoto() == null)) {
            boolean validatePhotoResponse = validatePhoto(post.getPhoto(), post.getUserId());
            if (!validatePhotoResponse) {
                post.setPhoto(null);
            }
        }

        return postClient.NewPost(post, tags);
    }

    @PostMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public boolean DeletePost(@RequestBody int postID) {
        return postClient.DeletePost(postID);
    }

    @PostMapping(value = "/getpost", consumes = "application/json", produces = "application/json")
    public Post GetPost(@RequestBody int postID) {
        return postClient.GetPost(postID);
    }

    @PostMapping(value = "/getposts", consumes = "application/json", produces = "application/json")
    public PostContainer LoadPostsFromChannel(@RequestBody int[] array) {
        return postClient.LoadPostsFromChannel(array[0], array[1]);
    }

    @PostMapping(value = "/likepost", consumes = "application/json", produces = "application/json")
    public boolean LikeThePost(@RequestBody int[] array) {
        return postClient.LikeThePost(array[0], array[1]);
    }

    @PostMapping(value = "/islikedpost", consumes = "application/json", produces = "application/json")
    public boolean IsAlreadyLiked(@RequestBody int[] array) {
        return postClient.IsAlreadyLiked(array[0], array[1]);
    }


    /*
    Logic methods
     */

    private List<String> extractTags(String content) {
        ArrayList<String> hashTagList = new ArrayList<String>();
        Matcher m = Pattern.compile("(#\\w+)\\b").matcher(content);
        while (m.find()) {
            hashTagList.add(m.group());
        }

        if (!hashTagList.isEmpty()) {
            for (String hashtag : hashTagList) {
                hashtag = hashtag.substring(1);
            }
        }
        return hashTagList;
    }

    private boolean validatePhoto(byte[] photo, int userId) {
        try {
            boolean scanResult;
            ApiClient defaultClient = Configuration.getDefaultApiClient();

            ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");
            Apikey.setApiKey("1cd184fc-369b-428d-ae1d-f389334454bd");

            ScanApi apiInstance = new ScanApi();

            String FILEPATH = "src\\main\\java\\fileContainerDirectory\\" + userId + ".txt";
            File file = new File(FILEPATH);
            OutputStream os = new FileOutputStream(file);
            os.write(photo);
            os.close();
            if (file.exists()) {
                VirusScanResult result = apiInstance.scanFile(file);
                scanResult = result.isCleanResult();
                file.delete();

                return scanResult;
            }
        } catch (IOException | ApiException e) {
            System.out.println("Problem occurred while validating photo " + e);
        }
        return false;
    }

}
