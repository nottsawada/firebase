package com.example.firebaseconnect.service;

import com.example.firebaseconnect.Entity.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.protobuf.Api;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

@Service
public class Productservice {

    private static final String COLLECTION_NAME = "product";

    public String saveProduct(Product product) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(product.getName()).set(product);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public Product getProductDetails(String name) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(name);

        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Product product = null;
        if (document.exists()) {
            product = document.toObject(Product.class);
            return product;
        } else {
            return null;
        }
        }
}