package com.chris.swapi.view;

import android.content.Intent;
import android.os.Bundle;

import com.chris.swapi.R;
import com.chris.swapi.databinding.ActivityRelatedMoviesViewBinding;
import com.chris.swapi.utils.StarWarsFilmsUtils;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class RelatedMoviesView extends AppCompatActivity {

private ActivityRelatedMoviesViewBinding mActivityRelatedMoviesViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityRelatedMoviesViewBinding=DataBindingUtil.setContentView(this,R.layout.activity_related_movies_view);

        Intent intent = getIntent();
       final String mCharacterNameID=intent.getExtras().getString("NameID");
       mActivityRelatedMoviesViewBinding.characterTitleView.setText(mCharacterNameID);
        ArrayList<String> list=intent.getStringArrayListExtra("RelatedMovieFilms");
        String[] movie_title_array =new String[6];
        for(int i=0; i<list.size(); i++)
        {
            String movie_title=list.get(i);
            movie_title_array[i]= StarWarsFilmsUtils.filmUrlToFilmTitle(movie_title);

        }
        for (String s : movie_title_array) {
            mActivityRelatedMoviesViewBinding.movieTitleView.setText(s);
        }
        mActivityRelatedMoviesViewBinding.executePendingBindings();

    }
}
