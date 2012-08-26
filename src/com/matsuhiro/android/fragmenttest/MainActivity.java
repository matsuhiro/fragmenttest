
package com.matsuhiro.android.fragmenttest;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "FragmentTest";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "Activity Enter onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
            Fragment newFragment = FirstFragment.newInstance("http://www.google.co.jp");
            ft.add(R.id.fragment_container, newFragment, "first");
            ft.commit();
        }
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = MainActivity.this.getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment newFragment = SecondFragment.newInstance("http://www.goo.ne.jp");
                ft.replace(R.id.fragment_container, newFragment, "second");
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        Log.v(TAG, "Activity Exit  onCreate");
    }

    @Override
    public void onBackPressed() {
        Log.v(TAG, "Activity Enter onBackPressed");
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        Fragment first = fm.findFragmentByTag("first");
        if (first instanceof FirstFragment && first.isVisible()) {
            Log.v(TAG, "Activity have first");
            if (((FirstFragment) first).canGoBack()) {
                ((FirstFragment) first).goBack();
                return;
            }
        }
        Fragment second = fm.findFragmentByTag("second");
        if (second instanceof SecondFragment && second.isVisible()) {
            Log.v(TAG, "Activity have second");
            if (((SecondFragment) second).canGoBack()) {
                ((SecondFragment) second).goBack();
                return;
            }
        }
        super.onBackPressed();
        Log.v(TAG, "Activity Exit  onBackPressed");
    }

    @Override
    public void onStart() {
        Log.v(TAG, "Activity Enter onStart");
        super.onStart();
        Log.v(TAG, "Activity Exit  onStart");
    }

    @Override
    public void onResume() {
        Log.v(TAG, "Activity Enter onResume");
        super.onResume();
        Log.v(TAG, "Activity Exit  onResume");
    }

    @Override
    public void onRestart() {
        Log.v(TAG, "Activity Enter onRestart");
        super.onRestart();
        Log.v(TAG, "Activity Exit  onRestart");
    }

    @Override
    public void onPause() {
        Log.v(TAG, "Activity Enter onPause");
        super.onPause();
        Log.v(TAG, "Activity Exit  onPause");
    }

    @Override
    public void onStop() {
        Log.v(TAG, "Activity Enter onStop");
        super.onStop();
        Log.v(TAG, "Activity Exit  onStop");
    }

    @Override
    public void onDestroy() {
        Log.v(TAG, "Activity Enter onDestroy");
        super.onDestroy();
        Log.v(TAG, "Activity Exit  onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        Log.v(TAG, "Activity Enter onSaveInstanceState");
        super.onSaveInstanceState(savedInstanceState);
        Log.v(TAG, "Activity Exit  onSaveInstanceState");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
