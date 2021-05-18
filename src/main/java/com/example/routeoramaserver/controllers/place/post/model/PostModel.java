package com.example.routeoramaserver.controllers.place.post.model;

import com.cloudmersive.client.ScanApi;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import com.cloudmersive.client.model.VirusScanResult;
import com.example.routeoramaserver.models.Post;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostModel implements IPostModel{
    @Override
    public Post ValidatePost(Post post) {
        if (!(post.getPhoto() == null)) {
            boolean validatePhotoResponse = validatePhoto(post.getPhoto(), post.getUserId());
            if (!validatePhotoResponse) {
                post.setPhoto(null);
            }
        }
        return post;
    }

    @Override
    public List<String> GetTags(Post post) {
        return extractTags(post.getContent());
    }

    private List<String> extractTags(String content) {
        ArrayList<String> hashTagList = new ArrayList<String>();
        Matcher m = Pattern.compile("(#\\w+)\\b").matcher(content);
        while (m.find()) {
            hashTagList.add(m.group());
        }

        ArrayList<String> tagList = new ArrayList<String>();
        if (!hashTagList.isEmpty()) {
            for (String hashtag : hashTagList) {
                tagList.add(hashtag.substring(1));
            }
        }

        return tagList;
    }

    private boolean validatePhoto(byte[] photo, int userId) {
        try {
            boolean scanResult;
            ApiClient defaultClient = Configuration.getDefaultApiClient();

            ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");
            Apikey.setApiKey("1cd184fc-369b-428d-ae1d-f389334454bd");

            ScanApi apiInstance = new ScanApi();

            String FILEPATH = "src\\main\\java\\com\\example\\routeoramaserver\\fileContainerDirectory\\"+userId+".txt";
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
