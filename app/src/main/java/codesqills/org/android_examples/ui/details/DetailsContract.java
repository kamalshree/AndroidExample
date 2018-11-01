package codesqills.org.android_examples.ui.details;

import codesqills.org.android_examples.ui.BasePresenter;
import codesqills.org.android_examples.ui.BaseView;

/**
 * Created by kamalshree on 10/31/2018.
 */

public interface DetailsContract {

    interface View extends BaseView<Presenter>{
        void navigateSuccessPage();
        void navigateFailurePage();
        void getDetails();
        void passDetails();
    }

    interface Presenter extends BasePresenter{
        void handleRequest();
        void handleDataSuccess(String name,String city,String age);
        void handleDatafailure(int statusCode, String message);
    }
}
