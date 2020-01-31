package com.example.mikkysblog;


import androidx.fragment.app.Fragment;



public class MainActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return MikkysBlogFragment.newinstance();
    }
}
