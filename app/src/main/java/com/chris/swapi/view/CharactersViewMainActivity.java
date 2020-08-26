package com.chris.swapi.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.chris.swapi.R;
import com.chris.swapi.adapter.CharactersAdapter;
import com.chris.swapi.model.People;
import com.chris.swapi.viewmodel.PeopleViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CharactersViewMainActivity extends AppCompatActivity {

    private PeopleViewModel mPeopleViewModel;
    private CharactersAdapter mCharactersAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupListAdapter();
        setupListOfCharacters();
    }

    private void setupListAdapter() {

        mLayoutManager= new LinearLayoutManager(CharactersViewMainActivity.this);
        mProgressBar=findViewById(R.id.progress_bar);

        mRecyclerView = findViewById(R.id.main_recycler_view);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);


        mCharactersAdapter=new CharactersAdapter(this,mPeopleViewModel);
        mRecyclerView.setAdapter(mCharactersAdapter);
        mPeopleViewModel = new ViewModelProvider(this).get(PeopleViewModel.class);

    }

    public void setupListOfCharacters()
    {
       mPeopleViewModel.itemPagedList.observe(this, new Observer<PagedList<People>>() {
           @Override
           public void onChanged(PagedList<People> people) {
               mProgressBar.setVisibility(View.GONE);
               mCharactersAdapter.submitList(people);
           }
       });
    }

}
