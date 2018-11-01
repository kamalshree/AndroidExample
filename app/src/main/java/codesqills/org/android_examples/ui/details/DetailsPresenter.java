package codesqills.org.android_examples.ui.details;

import android.widget.Toast;

import codesqills.org.android_examples.data.DataHandler;
import codesqills.org.android_examples.data.DataHandlerProvider;

/**
 * Created by kamalshree on 10/31/2018.
 */

public class DetailsPresenter implements  DetailsContract.Presenter {

    private DetailsContract.View mView;
    private DataHandler mDataHandler;

    @Override
    public void start() {

    }

    public DetailsPresenter(DetailsContract.View mView) {
        this.mView = mView;
        this.mDataHandler = DataHandlerProvider.provide();
        mView.setPresenter(this);
    }

    @Override
    public void destroy() {
        this.mView=null;
    }

    @Override
    public void handleRequest() {
        mView.showLoading();
        mView.getDetails();
        mView.passDetails();
    }

    @Override
    public void handleDataSuccess(String name, String city, String age) {
        mDataHandler.saveName(name);
        mDataHandler.saveCity(city);
        mDataHandler.saveAge(age);
        mView.hideLoading();

        //send

        mDataHandler.setUserInfo(new DataHandler.Callback<Void>() {
            @Override
            public void onResponse(Void result) {
                mView.navigateSuccessPage();
            }

            @Override
            public void onError() {
                mView.navigateFailurePage();
            }
        });
    }

    @Override
    public void handleDatafailure(int statusCode, String message) {
        //Something went wrong while storing data in firebase
    }
}
