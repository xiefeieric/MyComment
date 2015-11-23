package uk.me.feixie.mycomment.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import uk.me.feixie.mycomment.R;

public class WelcomeActivity extends Activity {

    private ViewPager vpWelcome;
    private List<View> mViewList;
    private Button btWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initViews();
        initListener();
    }

    private void initViews() {
        vpWelcome = (ViewPager) findViewById(R.id.vpWelcome);
        btWelcome = (Button) findViewById(R.id.btWelcome);
        initData();
        MyPagerAdapter adapter = new MyPagerAdapter();
        vpWelcome.setAdapter(adapter);
    }

    private void initListener() {

        vpWelcome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==2) {
                    btWelcome.setVisibility(View.VISIBLE);
                } else {
                    btWelcome.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);
                SharedPreferences.Editor edit = config.edit();
                edit.putBoolean("is_first",false).apply();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }

    private void initData() {
        mViewList = new ArrayList<>();
        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.drawable.guide_01);
        mViewList.add(imageView1);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.drawable.guide_02);
        mViewList.add(imageView2);
        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.drawable.guide_03);
        mViewList.add(imageView3);
    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mViewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
        }
    }
}
