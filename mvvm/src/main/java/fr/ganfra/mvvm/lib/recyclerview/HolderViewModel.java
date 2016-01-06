package fr.ganfra.mvvm.lib.recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class HolderViewModel<T, B extends ViewDataBinding, VM extends ItemViewModel> extends RecyclerView.ViewHolder {

    protected Context mContext;
    protected B mBinding;
    protected VM mViewModel;

    protected abstract VM createViewModel();

    protected abstract void attachViewModel(B binding, VM viewModel);

    public HolderViewModel(Context context, View view) {
        super(view);
        mContext = context;
        mBinding = DataBindingUtil.bind(view);
        mViewModel = createViewModel();
        attachViewModel(mBinding, mViewModel);
    }

    public final void bind(T item) {
        mViewModel.setItem(item);
        mBinding.executePendingBindings();
    }
}
