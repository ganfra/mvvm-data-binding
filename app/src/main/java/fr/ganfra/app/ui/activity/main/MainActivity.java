package fr.ganfra.app.ui.activity.main;

import fr.ganfra.app.R;
import fr.ganfra.app.databinding.ActivityMainBinding;
import fr.ganfra.mvvm.lib.ActivityViewModel;

public class MainActivity extends ActivityViewModel<ActivityMainBinding, MainViewModel> {

    @Override
    protected void setupUI(ActivityMainBinding binding) {
        super.setupUI(binding);
    }

    @Override
    protected MainViewModel createViewModel() {
        return new MainViewModel(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void attachViewModel(ActivityMainBinding binding, MainViewModel viewModel) {
        binding.setViewModel(viewModel);
    }
}
