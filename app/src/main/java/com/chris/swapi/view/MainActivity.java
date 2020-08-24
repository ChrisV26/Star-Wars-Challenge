package com.chris.swapi.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.chris.swapi.R;
import com.chris.swapi.adapter.CharactersAdapter;
import com.chris.swapi.model.People;
import com.chris.swapi.viewmodel.PeopleViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * View: the main view of the App
 */
public class MainActivity extends AppCompatActivity {

    private PeopleViewModel mPeopleViewModel;
    private ArrayList<People> mPeopleArrayList=new ArrayList<>();
    private CharactersAdapter mCharactersAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupListAdapter();
        getCharacters();


    }

    private void setupListAdapter() {

        mLayoutManager= new LinearLayoutManager(MainActivity.this);
        mProgressBar=findViewById(R.id.progress_bar);

        mRecyclerView = findViewById(R.id.main_recycler_view);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);


        //mCharactersAdapter=new CharactersAdapter(MainActivity.this,mPeopleArrayList);
        mCharactersAdapter=new CharactersAdapter(this,mPeopleViewModel);
        mRecyclerView.setAdapter(mCharactersAdapter);
        mPeopleViewModel = new ViewModelProvider(this).get(PeopleViewModel.class);

    }

    public void getCharacters()
    {
       /* mPeopleViewModel.getSWModelListResponseLiveData().observe(this, swModelList -> {
            if (swModelList != null) {
                mProgressBar.setVisibility(View.GONE);
                List<People> characters = swModelList.getResults();
                mPeopleArrayList.addAll(characters);
                mCharactersAdapter.notifyDataSetChanged();
            }
        });*/

       mPeopleViewModel.itemPagedList.observe(this, new Observer<PagedList<People>>() {
           @Override
           public void onChanged(PagedList<People> people) {
               mProgressBar.setVisibility(View.GONE);
               mCharactersAdapter.submitList(people);
           }
       });
    }

}
