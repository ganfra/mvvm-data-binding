package fr.ganfra.mvvm.lib;

import android.content.Context;
import android.os.Parcelable;

public abstract class SavedViewModel extends ViewModel {

    public static final String EXTRA_VIEW_MODEL_DATA = "EXTRA_VIEW_MODEL_DATA";

    public SavedViewModel(Context context) {
        super(context);
    }

    public abstract void restoreData(Parcelable data);

    public abstract Parcelable getDataToSave();

}
