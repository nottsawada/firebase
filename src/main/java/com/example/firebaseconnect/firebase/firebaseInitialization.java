package com.example.firebaseconnect.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class firebaseInitialization {

    @PostConstruct
    public void initialization() {

        try {

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource("serviceAccountKey.json").getInputStream()))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
