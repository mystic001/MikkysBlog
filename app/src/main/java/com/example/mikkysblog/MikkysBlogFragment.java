package com.example.mikkysblog;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class MikkysBlogFragment extends Fragment {

    public static final String HOME = "http://mikkyanu.blogspot.com/";
    private ProgressBar mProgressBar;


    public static  Fragment newinstance(){

        return new MikkysBlogFragment();
    }


    public MikkysBlogFragment() {
        // Required empty public constructor
    }



    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_mikkys_blog, container, false);
        WebView mWeb = view.findViewById(R.id.web);
        final AppCompatActivity activity = (AppCompatActivity) getActivity();
        Toolbar bar = view.findViewById(R.id.toolbar);
        assert activity != null;
        activity.setSupportActionBar(bar);


        ActionBar actionBar = activity.getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);


        mProgressBar = view.findViewById(R.id.progressBar);
        mProgressBar.setMax(100); // WebChromeClient reports in range 0-100
        mWeb.getSettings().setJavaScriptEnabled(true);
        mWeb.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView webView, int newProgress) {
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                } else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(newProgress);
                }
            }
            public void onReceivedTitle(WebView webView, String title) {

                activity.getSupportActionBar().setSubtitle(title);
            }
        });
        mWeb.setWebViewClient(new WebViewClient());
        mWeb.loadUrl(HOME);
        return view ;
    }



    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mikkys_blog, container, false);
    }*/

}
