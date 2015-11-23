package uk.me.feixie.mycomment.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import uk.me.feixie.mycomment.R;

public class FlashActivity extends Activity {

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (mIs_first) {
                        startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));
                    } else {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };
    private SharedPreferences mConfig;
    private boolean mIs_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        mConfig = getSharedPreferences("config", MODE_PRIVATE);
        mIs_first = mConfig.getBoolean("is_first", true);
        mHandler.sendEmptyMessageDelayed(0,3000);
    }
}
