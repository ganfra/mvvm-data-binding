package fr.ganfra.mvvm.lib;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;


public abstract class ActivityViewModel<B extends ViewDataBinding, VM extends ViewModel> extends AppCompatActivity {

    protected VM mViewModel;
    protected B mBinding;

    protected abstract VM createViewModel();

    @LayoutRes
    protected abstract int getLayoutResId();

    protected abstract void attachViewModel(B binding, VM viewModel);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mViewModel == null) {
            mViewModel = createViewModel();
            if (mViewModel instanceof SavedViewModel && savedInstanceState != null) {
                final SavedViewModel savedViewModel = (SavedViewModel) mViewModel;
                final Parcelable data = (Parcelable) savedInstanceState.get(SavedViewModel.EXTRA_VIEW_MODEL_DATA);
                savedViewModel.restoreData(data);
            }
        }
        final B binding = DataBindingUtil.setContentView(this, getLayoutResId());
        mBinding = binding;
        attachViewModel(mBinding, mViewModel);
        setupUI(binding);
    }

    protected void setupUI(B binding) {
        // OVERRIDE THIS
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mViewModel instanceof SavedViewModel) {
            final SavedViewModel savedViewModel = (SavedViewModel) mViewModel;
            final Parcelable data = savedViewModel.getDataToSave();
            outState.putParcelable(SavedViewModel.EXTRA_VIEW_MODEL_DATA, data);
        }
    }

    @Override
    protected void onPause() {
        mViewModel.onPause();
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewModel.onResume();
    }

    @Override
    protected void onDestroy() {
        mViewModel.onDestroy();
        super.onDestroy();
    }
}
