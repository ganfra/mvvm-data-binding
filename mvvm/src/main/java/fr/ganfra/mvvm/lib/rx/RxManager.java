package fr.ganfra.mvvm.lib.rx;

import rx.Observable;
import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

public class RxManager {


    public <T> void subscribe(Observable<T> observable, Action1<? super T> onNext, Action1<Throwable> onError, Action0 onCompleted) {
        final Observer<T> observer = createObserver(onNext, onError, onCompleted);
        subscribe(observable, observer);
    }

    public <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        
    }


    private <T> Observer<T> createObserver(final Action1<? super T> onNext, final Action1<Throwable> onError, final Action0 onCompleted) {
        final Observer<T> observer = new Observer<T>() {
            @Override
            public void onCompleted() {
                if (onCompleted != null) {
                    onCompleted.call();
                }
            }

            @Override
            public void onError(Throwable e) {
                if (onError != null) {
                    onError.call(e);
                }
            }

            @Override
            public void onNext(T t) {
                if (onNext != null) {
                    onNext.call(t);
                }
            }
        };
        return observer;
    }

    public void onPause() {

    }

    public void onResume() {

    }


}
