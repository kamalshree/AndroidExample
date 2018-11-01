package codesqills.org.android_examples;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kamalshree on 10/31/2018.
 */

public class PrefsHelper {

    private static final String PREFERENCES_NAME = "name_app_prefs";
    private SharedPreferences mPrefs;
    private static PrefsHelper sInstance = null;

    private PrefsHelper(Context context) {
        mPrefs = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public static PrefsHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (PrefsHelper.class) {
                if (sInstance == null) {
                    sInstance = new PrefsHelper(context);
                }
            }
        }
        return sInstance;
    }

    private static final String KEY_USER_NAME = "key_user_name";
    private String mUserName;

    public String getmUserName() {
        if (mUserName == null) {
            mUserName = mPrefs.getString(KEY_USER_NAME, null);
        }
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
        mPrefs.edit().putString(KEY_USER_NAME,mUserName).apply();
    }

    void destroy(){
        mPrefs.edit().clear().apply();
        mUserName=null;
    }
}
