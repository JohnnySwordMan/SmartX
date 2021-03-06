package com.abyte.wanandroid.base.presenter;

import com.abyte.wanandroid.base.view.AbstractView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * BasePresenter
 * Created by geyan on 2018
 */
public abstract class BasePresenter<T extends AbstractView> implements AbstractPresenter<T> {

    protected Reference<T> mViewRef;
    private CompositeDisposable compositeDisposable;
    //    protected T mView;

    public BasePresenter() {
    }

    /**
     * 1.这里使用弱引用的原因：
     * 很多人会说(很多面试官)，你在Activity的onDestroy中，直接解除对Activity的引用，就没有必要再使用弱引用了。
     * 回答：并不是在任何情况下Activity的onDestroy方法都会被调用，一旦这种情况发生，弱引用也能保证不会发生内存泄漏。
     *
     * 2.MainActivity--->FirstActivity，此时直接杀进程，只会执行MainActivity的onDestroy方法，而不会执行FirstActivity的方法
     */
    @Override
    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
        // 取消订阅
        if(compositeDisposable != null){
            compositeDisposable.clear();
        }
    }

    public void addSubscriber(Disposable disposable){
        if(compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    @Override
    public T getView() {
        return mViewRef.get();
    }

    @Override
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

}
