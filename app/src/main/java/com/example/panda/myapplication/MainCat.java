package com.example.panda.myapplication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.support.v4.app.Fragment;

public class MainCat extends AppCompatActivity {


    private TextView mTextMessage;

    private Fragment[] fragments;
    private int lastShowFragment = 0;
    private FrameLayout fl;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    if (lastShowFragment != 0) {
                        switchFrament(lastShowFragment, 0);
                        lastShowFragment = 0;
                    }
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    if (lastShowFragment != 1) {
                        switchFrament(lastShowFragment, 1);
                        lastShowFragment = 1;
                    }
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    if (lastShowFragment != 2) {
                        switchFrament(lastShowFragment, 2);
                        lastShowFragment = 2;
                    }
                    return true;
            }
            return false;
        }

    };

    public void switchFrament(int lastIndex, int index) {

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.hide(fragments[lastIndex]);

        if (!fragments[index].isAdded()) {

            transaction.add(R.id.content, fragments[index]);
        }

        transaction.show(fragments[index]).commitAllowingStateLoss();
    }
    private void initFragments() {

        Fragment one = new Fragmentone();
        Fragment one2 = new Fragmenttwo() ;
        Fragment one3 = new Fragmentthree();

        fragments = new Fragment[]{one, one2, one3};
        lastShowFragment = 0;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, one)
                .show(one)
                .commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        } //去标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cat);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fl = (FrameLayout) findViewById(R.id.content);

        initFragments();


    }

}
