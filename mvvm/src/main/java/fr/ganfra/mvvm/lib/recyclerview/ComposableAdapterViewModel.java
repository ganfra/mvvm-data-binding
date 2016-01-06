package fr.ganfra.mvvm.lib.recyclerview;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.view.ViewGroup;

public abstract class ComposableAdapterViewModel<T> extends AdapterViewModel<T> {

    protected ViewHolderManager<T> mHolderManager;

    public ComposableAdapterViewModel(Context context, ObservableArrayList<T> items) {
        super(context, items);
        mHolderManager = new ViewHolderManager<>();
    }

    @Override
    public HolderViewModel onCreateViewHolder(ViewGroup parent, int viewType) {
        return mHolderManager.onCreateViewHolder(mContext, mInflater, parent, viewType);
    }

    @Override
    public void onBindViewHolder(HolderViewModel holder, int position) {
        if (mItems != null) {
            final T item = mItems.get(position);
            mHolderManager.onBindViewHolder(item, (HolderViewModel) holder);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mHolderManager.getItemViewType(mItems, position);
    }

}
