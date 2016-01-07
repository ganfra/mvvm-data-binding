package fr.ganfra.mvvm.lib;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentViewModel<B extends ViewDataBinding, VM extends ViewModel> extends Fragment {

    protected VM mViewModel;
    protected B mBinding;

    protected abstract VM createViewModel();

    @LayoutRes
    protected abstract int getLayoutResId();

    protected abstract void attachViewModel(B binding, VM viewModel);

    protected abstract void setupUI(B binding);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mViewModel == null) {
            mViewModel = createViewModel();
            if (mViewModel instanceof SavedViewModel && savedInstanceState != null) {
                final SavedViewModel savedViewModel = (SavedViewModel) mViewModel;
                final Parcelable data = (Parcelable) savedInstanceState.get(SavedViewModel.EXTRA_VIEW_MODEL_DATA);
                savedViewModel.restoreData(data);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final B binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        mBinding = binding;
        attachViewModel(mBinding, mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUI(mBinding);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mViewModel instanceof SavedViewModel) {
            final SavedViewModel savedViewModel = (SavedViewModel) mViewModel;
            final Parcelable data = savedViewModel.getDataToSave();
            outState.putParcelable(SavedViewModel.EXTRA_VIEW_MODEL_DATA, data);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }

    @Override
    public void onPause() {
        mViewModel.onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.onResume();
    }

    @Override
    public void onDestroy() {
        mViewModel.onDestroy();
        super.onDestroy();
    }
}
