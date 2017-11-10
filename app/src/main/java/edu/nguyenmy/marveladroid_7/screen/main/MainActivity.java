package edu.nguyenmy.marveladroid_7.screen.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import edu.nguyenmy.marveladroid_7.R;
import edu.nguyenmy.marveladroid_7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();

    }
    private void initDataBinding() {
        mMainViewModel = new MainViewModel();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainViewModel(mMainViewModel);
        setSupportActionBar(binding.toolBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }
}
