package codesqills.org.android_examples.ui;

/**
 * Created by kamalshree on 10/31/2018.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
    void showLoading();
    void hideLoading();
}

