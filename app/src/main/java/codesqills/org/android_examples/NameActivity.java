package codesqills.org.android_examples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

/**
 * Created by kamalshree on 10/31/2018.
 */

public class NameActivity extends AppCompatActivity {

    EditText mName;
    Button mAdd;
    String nameVal;
    private PrefsHelper mPreferences;

    @Override
    protected void onStart() {
        super.onStart();
        mPreferences = PrefsHelper.getInstance(this);

        if(mPreferences.getmUserName()!= null){
            loadDisplayScreen();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        IntializeUI();

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameVal=mName.getText().toString();
                mPreferences.setmUserName(nameVal);
                Toast.makeText(NameActivity.this, "Data Saved , Re-open the App again", Toast.LENGTH_SHORT).show();
                loadDisplayScreen();
            }
        });

    }

    private void IntializeUI() {
        mName=(EditText) findViewById(R.id.ed_name);
        mAdd=(Button) findViewById(R.id.btn_add);
    }

    private void loadDisplayScreen(){
        Intent nameIntent=new Intent(this,DisplayActivity.class);
        startActivity(nameIntent);
    }
}
