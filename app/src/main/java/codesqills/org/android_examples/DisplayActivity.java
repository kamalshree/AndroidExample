package codesqills.org.android_examples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kamalshree on 10/31/2018.
 */

public class DisplayActivity extends AppCompatActivity {
    private PrefsHelper mPreferences;
    TextView mDisplayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        mPreferences = PrefsHelper.getInstance(this);
        displayVal();

    }

    private void displayVal() {
        mDisplayName=(TextView)findViewById(R.id.tv_myName);
        mDisplayName.setText("Hello "+mPreferences.getmUserName());

    }

}
