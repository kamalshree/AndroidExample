package codesqills.org.android_examples.data.remote;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import codesqills.org.android_examples.data.models.Users;

/**
 * Created by kamalshree on 10/31/2018.
 */

public class FirebaseHandlerImpl implements FirebaseHandler {

    private static final String KEY_USER_NAME = "name";
    private static final String KEY_USER_AGE= "age";
    private static final String KEY_USER_CITY= "city";

    // Private variables
    private FirebaseUser mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference mUsersRef;

    FirebaseHandlerImpl() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference();
        mUsersRef = rootRef.child(REF_USERS_NODE);
    }

    @Override
    public void setUserInfo(Users currentUser, final Callback<Void> callback) {
        Map<String, Object> userData = new HashMap<>();
        userData.put(KEY_USER_AGE, currentUser.getmAge());
        userData.put(KEY_USER_CITY, currentUser.getmCity());
        userData.put(KEY_USER_NAME, currentUser.getmName());


        if (mCurrentUser == null) {
            mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        }
        String userId = mUsersRef.push().getKey();
        mUsersRef.child(userId).updateChildren(userData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        callback.onReponse(null);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        callback.onError();
                    }
                });
    }
}
