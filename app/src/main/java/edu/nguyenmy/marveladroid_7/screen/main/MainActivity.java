package edu.nguyenmy.marveladroid_7.screen.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import edu.nguyenmy.marveladroid_7.R;
import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.source.CharacterRepository;
import edu.nguyenmy.marveladroid_7.data.source.remote.CharacterDataSource;
import edu.nguyenmy.marveladroid_7.data.source.remote.CharacterRemoteDataSource;
import edu.nguyenmy.marveladroid_7.data.source.remote.CharacterServiceClient;
import edu.nguyenmy.marveladroid_7.data.source.remote.api.APICharacter;
import edu.nguyenmy.marveladroid_7.databinding.ActivityMainBinding;
import edu.nguyenmy.marveladroid_7.utils.Constant;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity {
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        CharacterRepository characterRepository = new CharacterRepository(
                new CharacterRemoteDataSource(CharacterServiceClient.getInstance()));
        ArrayList<Character> characters = getIntent().getParcelableArrayListExtra(Constant.ARGUMENT_LIST_CHARACTER);
        MainAdapter mainAdapter = new MainAdapter(this,characters);
        mMainViewModel = new MainViewModel(characterRepository, this,mainAdapter );

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
