package com.framgia.nguyenson.lesson8.screen.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.framgia.nguyenson.lesson8.R;
import com.framgia.nguyenson.lesson8.data.model.Repos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements SearchView.OnQueryTextListener,
        MainContract.View {
    private RecyclerView mRecyclerView;
    private ReposAdapter mReposAdapter;
    private SearchView mSearchView;
    private MainContract.Presenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);

        mMainPresenter = new MainPresenter();
        mMainPresenter.setView(this);
        mMainPresenter.load("https://api.github.com/users/google/repos");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mReposAdapter = new ReposAdapter(new ArrayList<Repos>(), this);
        mRecyclerView.setAdapter(mReposAdapter);
        mReposAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mMainPresenter.search(newText);
        return true;
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem itemSearch = menu.findItem(R.id.search_view);
        mSearchView = (SearchView) itemSearch.getActionView();
        mSearchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public void showList(List<Repos> list) {
        if (list == null) return;
        mReposAdapter.setArrayList(list);
        mReposAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }
}
