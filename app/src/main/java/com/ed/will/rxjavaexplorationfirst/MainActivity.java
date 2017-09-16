package com.ed.will.rxjavaexplorationfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private final String TAG="Rx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,Thread.currentThread().getName());
        //demo1();
        //demo2();
        //demo3();
        demo4();
    }

    private void demo4() {
        
    }

    private void demo3() {
        Observable.create(new  ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("111");
                e.onNext("111");
                e.onNext("111");
                e.onComplete();
                e.onNext("111");
                e.onNext("111");
                e.onNext("111");
                e.onNext("111");

            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG,s);
            }
        });
    }

//    private void demo2() {
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
//                e.onNext("aaaaa");
//                e.onNext("bbbbb");
//                e.onNext("ccccc");
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                Log.d(TAG,"subscribe");
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                Log.d(TAG,""+s);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d(TAG,"error");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG,"complete");
//            }
//        });
//    }

//    private void demo1() {
//
//        Observable<Integer> observable=Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        });
//
//        Observer<Integer> observer=new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                Log.d(TAG,"subscribe");
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Log.d(TAG,""+integer);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d(TAG,"error");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG,"complete");
//            }
//        };
//
//        observable.subscribe(observer);
//    }


}
