package fr.ganfra.mvvm.lib.recyclerview;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public abstract class AdapterViewModel<T> extends RecyclerView.Adapter<HolderViewModel> {

    protected Context mContext;
    protected LayoutInflater mInflater;

    protected ObservableArrayList<T> mItems;

    public AdapterViewModel(final Context context, final ObservableArrayList<T> items) {
        mContext = context.getApplicationContext();
        mInflater = LayoutInflater.from(mContext);
        mItems = items;
        mItems.addOnListChangedCallback(new OnListChangedCallback(this));
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }


    private class OnSubcribeToList implements Observable.OnSubscribe<List<Object>> {

        List<Object> list;

        




        @Override
        public void call(Subscriber<? super List<Object>> subscriber) {

        }
    }

}

