package fr.ganfra.mvvm.lib;

import android.os.Parcelable;

public interface ISavedViewModel {

    final String EXTRA_VIEW_MODEL_DATA = "EXTRA_VIEW_MODEL_DATA";

    public abstract void restoreData(Parcelable data);

    public abstract Parcelable getDataToSave();

}
