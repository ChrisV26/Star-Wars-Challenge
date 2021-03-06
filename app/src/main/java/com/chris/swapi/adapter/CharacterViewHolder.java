package com.chris.swapi.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chris.swapi.databinding.ItemPeopleBinding;
import com.chris.swapi.model.People;
import com.chris.swapi.view.RelatedMoviesView;

import androidx.recyclerview.widget.RecyclerView;

public class CharacterViewHolder extends RecyclerView.ViewHolder {

    private final ItemPeopleBinding binding;

    /**
     * Custom view holder to hold the view to display in
     * the RecyclerView.
     * @param binding generated in order to bind UI components
     */
    public CharacterViewHolder(ItemPeopleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bindTo(final People people)
    {
        binding.setPerson(people);
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // sent Character Name and the movies he was part of to the RelatedMoviesView Activity
                Intent intent=new Intent(view.getContext(), RelatedMoviesView.class);
                intent.putExtra("NameID",people.getName());
                intent.putStringArrayListExtra("RelatedMovieFilms",people.getRelatedFilms());
                view.getContext().startActivity(intent);
            }
        });
        binding.executePendingBindings();
    }

    static CharacterViewHolder create(ViewGroup parent)
    {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());

        ItemPeopleBinding binding=
                ItemPeopleBinding.inflate(layoutInflater,parent,false);
        return new CharacterViewHolder(binding);
    }
}
