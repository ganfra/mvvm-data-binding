package fr.ganfra.mvvm.lib;

import android.content.Context;

import fr.ganfra.mvvm.lib.rx.RxManager;

public abstract class ViewModel {

    private Context mAppContext;
    private RxManager mRxManager;

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
