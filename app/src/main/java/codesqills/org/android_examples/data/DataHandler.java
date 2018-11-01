package codesqills.org.android_examples.data;

/**
 * Created by kamalshree on 10/31/2018.
 */

public interface DataHandler {

    void saveName(String Name);
    void saveAge(String Age);
    void saveCity(String City);

    String getName();
    String getAge();
    String getCity();
    void setUserInfo(Callback<Void> callback);

    interface Callback<T> {
        void onResponse(T result);
        void onError();
    }
}
