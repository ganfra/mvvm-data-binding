package fr.ganfra.mvvm.lib.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public interface IHolderComposer<T> {

    boolean isForViewType(List<T> items, int position);

    HolderViewModel onCreateViewHolder(Context context, LayoutInflater layoutInflater, ViewGroup parent);

    void onBindViewHolder(T item, HolderViewModel holder);
}
