package codesqills.org.android_examples.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import codesqills.org.android_examples.R;
import codesqills.org.android_examples.ui.PresenterInjector;
import codesqills.org.android_examples.ui.success.SuccessActivity;

/**
 * Created by kamalshree on 10/31/2018.
 */

public class DetailsActivity extends AppCompatActivity implements DetailsContract.View {
    LottieAnimationView mLoading;
    Button mAdd;
    EditText mName;
    EditText mAge;
    EditText mCity;
    String nameVal,ageVal,cityVal;

    DetailsContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initializeUi();

        PresenterInjector.injectDetailsPresenter(this);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.handleRequest();
            }
        });
    }

    private void initializeUi() {
        mAdd=(Button) findViewById(R.id.btn_add);
        mLoading=(LottieAnimationView)findViewById(R.id.lottieAnimationView);
        mName=(EditText) findViewById(R.id.ed_name);
        mCity=(EditText) findViewById(R.id.ed_city);
        mAge=(EditText) findViewById(R.id.ed_age);
    }

    public void setPresenter(DetailsContract.Presenter presenter) {
        this.mPresenter = presenter;
    }


    @Override
    public void showLoading() {
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoading.setVisibility(View.GONE);
    }

    @Override
    public void navigateSuccessPage() {
        Intent successIntent=new Intent(this,SuccessActivity.class);
        startActivity(successIntent);
    }

    @Override
    public void navigateFailurePage() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDetails() {
        nameVal=mName.getText().toString();
        cityVal=mCity.getText().toString();
        ageVal=mAge.getText().toString();
    }

    @Override
    public void passDetails() {

        mPresenter.handleDataSuccess(nameVal,cityVal,ageVal);
    }
}
