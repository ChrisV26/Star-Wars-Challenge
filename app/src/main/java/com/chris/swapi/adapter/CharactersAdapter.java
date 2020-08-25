package com.chris.swapi.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.chris.swapi.model.People;
import com.chris.swapi.viewmodel.PeopleViewModel;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Setup the Character List Adapter
 */

public class CharactersAdapter extends
        PagedListAdapter<People,RecyclerView.ViewHolder> {

    private Context mContext;
    private PeopleViewModel mPeopleViewModel;

    public CharactersAdapter(Context context,PeopleViewModel PeopleViewModel) {
        super(DIFF_CALLBACK);
        this.mContext=context;
        mPeopleViewModel=PeopleViewModel;
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  CharacterViewHolder.create(parent);
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       getItemViewType(position);
        ((CharacterViewHolder)holder).bindTo(getItem(position));

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    // Diff Util to calculate the difference between the old and new list of items based on name
    private static DiffUtil.ItemCallback<People> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<People>() {
                @Override
                public boolean areItemsTheSame(People oldItem, People newItem) {
                    if (oldItem == null || newItem == null) return false;
                    return oldItem == newItem;
                }

                @Override
                public boolean areContentsTheSame(People oldItem, People newItem) {
                    if (oldItem == null || newItem == null) return false;
                    return oldItem.name.equals(newItem.name);
                }
            };

}
