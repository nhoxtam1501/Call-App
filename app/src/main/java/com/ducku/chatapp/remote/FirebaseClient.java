package com.ducku.chatapp.remote;

import com.ducku.chatapp.utils.SuccessCallBack;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

public class FirebaseClient {
    private final Gson gson = new Gson();
    private final DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private String currentUsername;
    private final String LATEST_EVENT_FIELD_NAME = "latest_event";

    public void login(String username, SuccessCallBack successCallBack) {
        reference.child(username).setValue("success").addOnCompleteListener(task -> {
            currentUsername = username;
            successCallBack.onSuccess();
        });
    }

    public void sendMessageToOtherUser() {

    }

    public void observeIncomingLatestEvent() {

    }
}
