package codesqills.org.android_examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    Button mLoadbtn;
    Button mHidebtn;
    LottieAnimationView mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntializeUI();

        mLoadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadAnimation();
            }
        });

        mHidebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideAnimation();
            }
        });
    }

    private void hideAnimation() {
        mLoading.setVisibility(View.GONE);
    }

    private void loadAnimation() {
        mLoading.setVisibility(View.VISIBLE);
    }

    private void IntializeUI() {
        mLoadbtn=(Button) findViewById(R.id.btn_load);
        mHidebtn=(Button) findViewById(R.id.btn_hide);
        mLoading=(LottieAnimationView)findViewById(R.id.lottieAnimationView);
    }

}
