package codesqills.org.android_examples.data;

import android.content.Context;

import codesqills.org.android_examples.PrefsHelper;
import codesqills.org.android_examples.data.models.Users;
import codesqills.org.android_examples.data.remote.FirebaseHandler;
import codesqills.org.android_examples.data.remote.FirebaseProvide;

/**
 * Created by kamalshree on 10/31/2018.
 */

public class AppDataHandler implements DataHandler {
    private static AppDataHandler INSTANCE = null;
    private FirebaseHandler mFirebaseHandler;

    String myName,myAge,myCity;

    private AppDataHandler() {
        mFirebaseHandler = FirebaseProvide.provide();
    }

    static AppDataHandler getInstance() {
        if (INSTANCE == null) {
            synchronized (AppDataHandler.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppDataHandler();
                }
            }
        }
        return INSTANCE;
    }
    @Override
    public void saveName(String Name) {
        this.myName=Name;
    }

    @Override
    public void saveAge(String Age) {
        this.myAge=Age;
    }

    @Override
    public void saveCity(String City) {
        this.myCity=City;
    }

    @Override
    public String getName() {
        return myName;
    }

    @Override
    public String getAge() {
        return myAge;
    }

    @Override
    public String getCity() {
        return myCity;
    }

    @Override
    public void setUserInfo(Callback<Void> callback) {
        Users users=new Users();
        users.setmAge(this.getAge());
        users.setmCity(this.getCity());
        users.setmName(this.getName());
        mFirebaseHandler.setUserInfo(users,new FirebaseCallback<>(callback));
    }

    class FirebaseCallback<T> implements FirebaseHandler.Callback<T> {
        DataHandler.Callback<T> callback;

        FirebaseCallback(DataHandler.Callback<T> callback) {
            this.callback = callback;
        }

        @Override
        public void onReponse(T result) {
            this.callback.onResponse(result);
        }

        @Override
        public void onError() {
            this.callback.onError();
        }
    }
}
