
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


public class FirstFragment extends Fragment {
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
            Log.d(TAG, "FirstFragment goBack");
            mWebview.goBack();
        }
    }

    static FirstFragment newInstance(String url) {
        Log.d(TAG, "FirstFragment Enter newInstance");
        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("url", url);
        f.setArguments(b);
        Log.d(TAG, "FirstFragment Exit  newInstance f = " + f.toString());
        return f;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "FirstFragment Enter onSaveInstanceState");
        super.onSaveInstanceState(savedInstanceState);
        String lasturl = mWebview.getUrl();
        savedInstanceState.putString("url", lasturl);
        Log.d(TAG, "FirstFragment Exit  onSaveInstanceState");
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d(TAG, "FirstFragment Enter onAttach");
        super.onAttach(activity);
        Log.d(TAG, "FirstFragment Exit  onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "FirstFragment Enter onCreate");
        super.onCreate(savedInstanceState);
        mLastUrl = null;
        Log.d(TAG, "FirstFragment Exit  onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "FirstFragment Enter onCreateView");
        mWebview = (WebView) inflater.inflate(R.layout.first_fragment, container, false);
        mWebview.setWebViewClient(new WebViewClient());
        String url = "http://www.yahoo.co.jp";
        Bundle args = getArguments();
        if (mLastUrl != null) {
            url = mLastUrl;
        } else if (savedInstanceState != null && savedInstanceState.containsKey("url")) {
            url = savedInstanceState.getString("url");
        } else if (args != null && args.containsKey("url")) {
            url = args.getString("url");
        }
        mWebview.loadUrl(url);
        Log.d(TAG, "FirstFragment Exit  onCreateView view = " + mWebview.toString());
        return mWebview;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(TAG, "FirstFragment Enter onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "FirstFragment Exit  onActivityCreated");
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        Log.d(TAG, "FirstFragment Enter onInflate");
        super.onInflate(activity, attrs, savedInstanceState);
        Log.d(TAG, "FirstFragment Exit  onInflate");
    }

    @Override
    public void onStart() {
        Log.d(TAG, "FirstFragment Enter onStart");
        super.onStart();
        Log.d(TAG, "FirstFragment Exit  onStart");
    }

    @Override
    public void onResume() {
        Log.d(TAG, "FirstFragment Enter onResume");
        super.onResume();
        Log.d(TAG, "FirstFragment Exit  onResume");
    }

    @Override
    public void onPause() {
        Log.d(TAG, "FirstFragment Enter onPause");
        super.onPause();
        Log.d(TAG, "FirstFragment Exit  onPause");
    }

    @Override
    public void onStop() {
        Log.d(TAG, "FirstFragment Enter onStop");
        super.onStop();
        Log.d(TAG, "FirstFragment Exit  onStop");
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "FirstFragment Enter onDestroyView");
        super.onDestroyView();
        Log.d(TAG, "FirstFragment getUrl=" + mWebview.getUrl());
        Log.d(TAG, "FirstFragment getOriginalUrl=" + mWebview.getOriginalUrl());
        mLastUrl = mWebview.getUrl();
        Log.d(TAG, "FirstFragment Exit  onDestroyView");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "FirstFragment Enter onDestroy");
        super.onDestroy();
        mLastUrl = null;
        Log.d(TAG, "FirstFragment Exit  onDestroy");
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "FirstFragment Enter onDetach");
        super.onDetach();
        Log.d(TAG, "FirstFragment Exit  onDetach");
    }

}
