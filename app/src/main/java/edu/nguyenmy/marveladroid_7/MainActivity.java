package edu.nguyenmy.marveladroid_7;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import edu.nguyenmy.marveladroid_7.databinding.ActivityMainBinding;
import edu.nguyenmy.marveladroid_7.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainViewModel = new MainViewModel();
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(mMainViewModel);
        setSupportActionBar(activityMainBinding.toolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu,menu);
        return true;
    }
}
