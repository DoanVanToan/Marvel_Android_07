package edu.nguyenmy.marveladroid_7.screen.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import java.util.ArrayList;
import java.util.List;

import edu.nguyenmy.marveladroid_7.R;
import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.source.CharacterRepository;
import edu.nguyenmy.marveladroid_7.data.source.remote.CharacterRemoteDataSource;
import edu.nguyenmy.marveladroid_7.data.source.remote.service.CharacterServiceClient;
import edu.nguyenmy.marveladroid_7.databinding.ActivityMainBinding;
import edu.nguyenmy.marveladroid_7.utils.Constant;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;



public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CharacterServiceClient.initialize(getApplication());
        CharacterRepository characterRepository = new CharacterRepository(
                new CharacterRemoteDataSource(CharacterServiceClient.getInstance()));

        mViewModel = new MainViewModel(characterRepository);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mViewModel);
        setSupportActionBar(binding.toolBar);
        mViewModel.getContentCharacter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
