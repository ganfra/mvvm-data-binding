package fr.ganfra.mvvm.lib.recyclerview;

import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;

public class OnListChangedCallback<T extends ObservableList> extends ObservableList.OnListChangedCallback<T> {

    private RecyclerView.Adapter mAdapter;

    public OnListChangedCallback(final RecyclerView.Adapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public void onChanged(T sender) {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRangeChanged(T sender, int positionStart, int itemCount) {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRangeInserted(T sender, int positionStart, int itemCount) {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRangeMoved(T sender, int fromPosition, int toPosition, int itemCount) {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRangeRemoved(T sender, int positionStart, int itemCount) {
        mAdapter.notifyDataSetChanged();
    }
}
