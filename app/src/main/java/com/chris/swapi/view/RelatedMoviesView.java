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
        setupRelatedMovieTitles();
    }

    private void setupRelatedMovieTitles() {
        Intent intent = getIntent();
        final String mCharacterNameID=intent.getExtras().getString("NameID");
        ArrayList<String> list=intent.getStringArrayListExtra("RelatedMovieFilms");

        mActivityRelatedMoviesViewBinding.characterTitleView.setText(mCharacterNameID);

        ArrayList<String> movieTitleArray = new ArrayList<>();
        for(int i=0; i<list.size(); i++)
        {
            String movie_title=list.get(i);
            // associate movie url to movie title and add them to the the list
            movieTitleArray.add(StarWarsFilmsUtils.filmUrlToFilmTitle(movie_title));

        }
        // Build a multiline text for a single text view
        StringBuilder builder=new StringBuilder();
        for (String s : movieTitleArray) {
            builder.append(s).append("\n");
            mActivityRelatedMoviesViewBinding.movieTitleView.setText(builder.toString());
        }
        mActivityRelatedMoviesViewBinding.executePendingBindings();
    }
}
