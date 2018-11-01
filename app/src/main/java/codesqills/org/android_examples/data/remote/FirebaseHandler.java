package codesqills.org.android_examples.data.remote;

import codesqills.org.android_examples.data.models.Users;

/**
 * Created by kamalshree on 10/31/2018.
 */

public interface FirebaseHandler {

    String REF_USERS_NODE = "users";

    void setUserInfo(Users currentUser, Callback<Void> callback);

    interface Callback<T> {
        void onReponse(T result);

        void onError();
    }
}
