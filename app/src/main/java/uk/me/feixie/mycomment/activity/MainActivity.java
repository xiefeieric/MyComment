package uk.me.feixie.mycomment.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import uk.me.feixie.mycomment.R;
import uk.me.feixie.mycomment.fragment.DiscoverFragment;
import uk.me.feixie.mycomment.fragment.GroupFragment;
import uk.me.feixie.mycomment.fragment.HomeFragment;
import uk.me.feixie.mycomment.fragment.MyAccountFragment;


public class MainActivity extends Activity {

    private RadioGroup rgNav;
    private RadioButton rbHome,rbGroup,rbDiscover,rbMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initViews() {
        rgNav = (RadioGroup) findViewById(R.id.rgNav);
        rbHome = (RadioButton) findViewById(R.id.rbHome);
        rbHome.setSelected(true);
        rbGroup = (RadioButton) findViewById(R.id.rbGroup);
        rbDiscover = (RadioButton) findViewById(R.id.rbDiscover);
        rbMy = (RadioButton) findViewById(R.id.rbMy);
    }

    private void initListeners() {

        getFragmentManager().beginTransaction().replace(R.id.flContent, new HomeFragment()).commit();

        //navigation controller
       rgNav.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               if (checkedId==rbHome.getId()) {
//                   System.out.println("home");
                   rbHome.setSelected(true);
                   rbGroup.setSelected(false);
                   rbDiscover.setSelected(false);
                   rbMy.setSelected(false);
                   getFragmentManager().beginTransaction().replace(R.id.flContent,new HomeFragment()).commit();
               } else if (checkedId==rbGroup.getId()){
//                   System.out.println("group");
                   rbHome.setSelected(false);
                   rbGroup.setSelected(true);
                   rbDiscover.setSelected(false);
                   rbHome.setSelected(false);
                   getFragmentManager().beginTransaction().replace(R.id.flContent,new GroupFragment()).commit();
               } else if (checkedId==rbDiscover.getId()) {
                   rbHome.setSelected(false);
                   rbGroup.setSelected(false);
                   rbDiscover.setSelected(true);
                   rbMy.setSelected(false);
//                   System.out.println("discover");
                   getFragmentManager().beginTransaction().replace(R.id.flContent,new DiscoverFragment()).commit();
               }else if (checkedId==rbMy.getId()) {
                   rbHome.setSelected(false);
                   rbGroup.setSelected(false);
                   rbDiscover.setSelected(false);
                   rbMy.setSelected(true);
                   getFragmentManager().beginTransaction().replace(R.id.flContent,new MyAccountFragment()).commit();
//                   System.out.println("my");
               }
           }
       });
    }


}
