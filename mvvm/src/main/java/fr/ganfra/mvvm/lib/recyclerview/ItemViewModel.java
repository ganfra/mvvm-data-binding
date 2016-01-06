package fr.ganfra.mvvm.lib.recyclerview;

import android.content.Context;

import fr.ganfra.mvvm.lib.ViewModel;

public abstract class ItemViewModel<T> extends ViewModel {

    protected T mItem;

    public ItemViewModel(Context context) {
        super(context);
    }

    public final void setItem(T item) {
        mItem = item;
        updateData(item);
    }

    public abstract void updateData(T item);

}
