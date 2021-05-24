package com.example.routeoramaserver.controllers.user.model;

import com.cloudmersive.client.ScanApi;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import com.cloudmersive.client.model.VirusScanResult;
import com.example.routeoramaserver.models.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UserModel implements IUserModel {

    @Override
    public User ValidateUser(User user) {
        if (!(user.getPhoto() == null)) {
            boolean validatePhotoResponse = validatePhoto(user.getPhoto(), user.getDisplayName());
            if (!validatePhotoResponse) {
                user.setPhoto(null);
            }
        }
        return user;
    }

    private boolean validatePhoto(byte[] photo, String displayName) {
        try {
            boolean scanResult;
            ApiClient defaultClient = Configuration.getDefaultApiClient();

            ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");
            Apikey.setApiKey("1cd184fc-369b-428d-ae1d-f389334454bd");

            ScanApi apiInstance = new ScanApi();

            String FILEPATH = "src\\main\\java\\com\\example\\routeoramaserver\\fileContainerDirectory\\"+displayName+".txt";
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
