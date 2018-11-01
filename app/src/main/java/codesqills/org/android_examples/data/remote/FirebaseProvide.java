package codesqills.org.android_examples.data.remote;

/**
 * Created by kamalshree on 10/31/2018.
 */

public class FirebaseProvide {
    public static FirebaseHandler provide(){
        return new FirebaseHandlerImpl();
    }
}
