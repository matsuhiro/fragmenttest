
package com.matsuhiro.android.fragmenttest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondFragment extends Fragment {
    private static final String TAG = "FragmentTest";
    private WebView mWebview = null;
    private String mLastUrl = null;

    public boolean canGoBack() {
        if (mWebview != null) {
            return mWebview.canGoBack();
        }
        return false;
    }

    public void goBack() {
        if (mWebview != null) {
            Log.i(TAG, "SecondFragment goBack");
            mWebview.goBack();
        }
    }

    static SecondFragment newInstance(String url) {
        Log.i(TAG, "SecondFragment Enter newInstance");
        SecondFragment f = new SecondFragment();
        Bundle b = new Bundle();
        b.putString("url", url);
        f.setArguments(b);
        Log.i(TAG, "SecondFragment Exit  newInstance f = " + f.toString());
        return f;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "SecondFragment Enter onSaveInstanceState");
        super.onSaveInstanceState(savedInstanceState);
        String lasturl = mWebview.getUrl();
        savedInstanceState.putString("url", lasturl);
        Log.i(TAG, "SecondFragment Exit  onSaveInstanceState");
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, "SecondFragment Enter onAttach");
        super.onAttach(activity);
        Log.i(TAG, "SecondFragment Exit  onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "SecondFragment Enter onCreate");
        super.onCreate(savedInstanceState);
        Log.i(TAG, "SecondFragment Exit  onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "SecondFragment Enter onCreateView");
        mWebview = (WebView) inflater.inflate(R.layout.second_fragment, container, false);
        mWebview.setWebViewClient(new WebViewClient());
        String url = "http://headlines.yahoo.co.jp/";
        Bundle args = getArguments();
        if (mLastUrl != null) {
            url = mLastUrl;
        } else if (savedInstanceState != null && savedInstanceState.containsKey("url")) {
            url = savedInstanceState.getString("url");
        } else if (args != null && args.containsKey("url")) {
            url = args.getString("url");
        }
        mWebview.loadUrl(url);
        Log.i(TAG, "SecondFragment Exit  onCreateView view = " + mWebview.toString());
        return mWebview;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, "SecondFragment Enter onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "SecondFragment Exit  onActivityCreated");
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        Log.i(TAG, "SecondFragment Enter onInflate");
        super.onInflate(activity, attrs, savedInstanceState);
        Log.i(TAG, "SecondFragment Exit  onInflate");
    }

    @Override
    public void onStart() {
        Log.i(TAG, "SecondFragment Enter onStart");
        super.onStart();
        Log.i(TAG, "SecondFragment Exit  onStart");
    }

    @Override
    public void onResume() {
        Log.i(TAG, "SecondFragment Enter onResume");
        super.onResume();
        Log.i(TAG, "SecondFragment Exit  onResume");
    }

    @Override
    public void onPause() {
        Log.i(TAG, "SecondFragment Enter onPause");
        super.onPause();
        Log.i(TAG, "SecondFragment Exit  onPause");
    }

    @Override
    public void onStop() {
        Log.i(TAG, "SecondFragment Enter onStop");
        super.onStop();
        Log.i(TAG, "SecondFragment Exit  onStop");
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "SecondFragment Enter onDestroyView");
        super.onDestroyView();
        Log.i(TAG, "SecondFragment getUrl=" + mWebview.getUrl());
        Log.i(TAG, "SecondFragment getOriginalUrl=" + mWebview.getOriginalUrl());
        mLastUrl = mWebview.getUrl();
        Log.i(TAG, "SecondFragment Exit  onDestroyView");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "SecondFragment Enter onDestroy");
        super.onDestroy();
        Log.i(TAG, "SecondFragment Exit  onDestroy");
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "SecondFragment Enter onDetach");
        super.onDetach();
        Log.i(TAG, "SecondFragment Exit  onDetach");
    }
}
