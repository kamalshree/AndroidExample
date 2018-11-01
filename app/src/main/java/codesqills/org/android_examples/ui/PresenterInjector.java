package codesqills.org.android_examples.ui;

import codesqills.org.android_examples.ui.details.DetailsContract;
import codesqills.org.android_examples.ui.details.DetailsPresenter;

/**
 * Created by kamalshree on 10/31/2018.
 */

public class PresenterInjector {
    public static void  injectDetailsPresenter(DetailsContract.View mview) {
        new DetailsPresenter(mview);
    }
}
