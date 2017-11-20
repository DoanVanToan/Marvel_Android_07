package edu.nguyenmy.marveladroid_7.screen.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import edu.nguyenmy.marveladroid_7.R;
import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.model.ItemComic;
import edu.nguyenmy.marveladroid_7.databinding.ActivityDetailBinding;
import edu.nguyenmy.marveladroid_7.screen.main.MainActivity;

/**
 * Created by DELL on 11/21/2017.
 */

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_CHARACTER = "EXTRA_CHARACTER";

    private DetailViewModel mDetailViewModel;

    public static Intent getInstance(Context context, Character character) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_CHARACTER, character);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //nhan du lieu tu main activity
        Character character = getIntent().getParcelableExtra(EXTRA_CHARACTER);
        mDetailViewModel = new DetailViewModel(character);
        ActivityDetailBinding binding = DataBindingUtil
                .setContentView(DetailActivity.this, R.layout.activity_detail);
        mDetailViewModel.getData();
        binding.setViewModel(mDetailViewModel);
        setSupportActionBar(binding.toolBar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.button_home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
