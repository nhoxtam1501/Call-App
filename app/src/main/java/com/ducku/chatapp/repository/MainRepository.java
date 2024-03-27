package com.ducku.chatapp.repository;

import com.ducku.chatapp.remote.FirebaseClient;
import com.ducku.chatapp.utils.SuccessCallBack;

public class MainRepository {
    private FirebaseClient client;
    private static MainRepository instance;
    private String currentUsername;

    private MainRepository() {
        client = new FirebaseClient();
    }

    private void updateCurrentUsername(String username) {
        this.currentUsername = username;
    }

    public static MainRepository getInstance() {
        synchronized (MainRepository.class) {
            if (instance == null) {
                instance = new MainRepository();
            }
        }
        return instance;
    }

    public void login(String username, SuccessCallBack callBack) {
        client.login(username, () -> {
            updateCurrentUsername(username);
            callBack.onSuccess();
        });
    }
}
