package fr.ganfra.mvvm.lib.recyclerview;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class ViewHolderManager<T> {

    SparseArrayCompat<IHolderComposer<T>> composers = new SparseArrayCompat();

    public ViewHolderManager<T> add(IHolderComposer composer) {
        return add(composer, 0);
    }

    public ViewHolderManager<T> add(IHolderComposer holder, int viewType) {
        if (holder == null) {
            throw new NullPointerException();
        }
        if (composers.get(viewType) != null) {
            throw new IllegalArgumentException("You have already provided a view holder for this type : " + viewType);
        }
        composers.put(viewType, holder);
        return this;
    }

    public int getItemViewType(List<T> items, int position) {
        int holdersCount = composers.size();
        for (int i = 0; i < holdersCount; i++) {
            IHolderComposer<T> composer = composers.valueAt(i);
            if (composer.isForViewType(items, position)) {
                return composers.keyAt(i);
            }
        }
        throw new IllegalArgumentException("No holder added that matches position=" + position + " in data");
    }

    public HolderViewModel onCreateViewHolder(Context context,LayoutInflater inflater, ViewGroup parent, int viewType) {
        final IHolderComposer<T> composer = composers.get(viewType);
        return composer.onCreateViewHolder(context,inflater, parent);
    }

    public void onBindViewHolder(T item, HolderViewModel viewHolder) {
        final IHolderComposer<T> composer = composers.get(viewHolder.getItemViewType());
        composer.onBindViewHolder(item, viewHolder);
    }
}
