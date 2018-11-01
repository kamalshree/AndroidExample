package codesqills.org.android_examples.data;

/**
 * Created by kamalshree on 10/31/2018.
 */

public class DataHandlerProvider {

    public static DataHandler provide() {

        return AppDataHandler.getInstance();
    }
}
