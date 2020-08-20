package com.chris.swapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chris.swapi.R;
import com.chris.swapi.model.People;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharactersAdapter extends
        RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder> {

    private Context mContext;
    private ArrayList<People> mPeopleList;

    public CharactersAdapter(Context context,ArrayList<People> peopleArrayList) {
        this.mContext=context;
        this.mPeopleList=peopleArrayList;
    }


    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to
     * represent an item.
     * @param parent   The ViewGroup into which the new View will be added after
     *                 it is bound to an adapter position.
     * @param viewType The view type of the new View. @return A new ViewHolder
     *                 that holds a View of the given view type.
     */
    @NonNull
    @Override
    public CharactersAdapter.CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate an item people view
        View mItemView=LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_people,parent,false);
        return new CharacterViewHolder(mItemView,this);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the ViewHolder.itemView to
     * reflect the item at the given position.
     *
     * @param holder   The ViewHolder which should be updated to represent
     *                 the contents of the item at the given position in the
     *                 data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CharactersAdapter.CharacterViewHolder holder, int position) {
        People currentPeople=mPeopleList.get(position);
        holder.mCharacterItemView.setText(currentPeople.getName());
    }

    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }


    static class CharacterViewHolder extends RecyclerView.ViewHolder
    {
        final TextView mCharacterItemView;
        final CharactersAdapter mAdapter;



        /**
         * Custom view holder to hold the view to display in
         * the RecyclerView.
         *
         * @param itemView The view in which to display the data.
         * @param adapter The adapter that manages the the data and views
         *                for the RecyclerView.
         */
        public CharacterViewHolder(@NonNull View itemView, CharactersAdapter adapter) {
            super(itemView);
            mCharacterItemView=itemView.findViewById(R.id.character_name_view);
            this.mAdapter=adapter;
            //itemView.setOnClickListener(this);
        }




    }


}
