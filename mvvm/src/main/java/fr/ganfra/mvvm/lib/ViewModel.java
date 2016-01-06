package fr.ganfra.mvvm.lib;

import android.content.Context;
import android.databinding.BaseObservable;

public abstract class ViewModel extends BaseObservable {

    private Context mAppContext;

    public ViewModel(final Context context) {
        mAppContext = context.getApplicationContext();
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    protected Context getAppContext() {
        return mAppContext;
    }

}
