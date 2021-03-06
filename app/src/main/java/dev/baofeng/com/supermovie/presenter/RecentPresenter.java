package dev.baofeng.com.supermovie.presenter;

import android.content.Context;

import dev.baofeng.com.supermovie.domain.BtInfo;
import dev.baofeng.com.supermovie.domain.RecentUpdate;
import dev.baofeng.com.supermovie.http.ApiManager;
import dev.baofeng.com.supermovie.presenter.iview.IMoview;
import dev.baofeng.com.supermovie.presenter.iview.IRecentView;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by huangyong on 2018/1/26.
 */

public class RecentPresenter extends BasePresenter<IRecentView>{

    public RecentPresenter(Context context, IRecentView iview) {
        super(context, iview);
    }


    public void getSerisUpdate(int page, int pagesize){

        Subscription subscription = ApiManager
                .getRetrofitInstance()
                .getSerisUpdate(page,pagesize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RecentUpdate>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        iview.loadFail("");
                    }
                    @Override
                    public void onNext(RecentUpdate result) {
                        iview.loadData(result);
                    }
                });
        addSubscription(subscription);
    }
    public void getSerisMore(int page,int pagesize) {
        Subscription subscription = ApiManager
                .getRetrofitInstance()
                .getSerisUpdate(page,pagesize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RecentUpdate>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(RecentUpdate result) {
                        iview.loadMore(result);
                    }
                });
        addSubscription(subscription);
    }

    public void getMovieUpdate(int page, int pagesize){

        Subscription subscription = ApiManager
                .getRetrofitInstance()
                .getRecomend(page,pagesize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RecentUpdate>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        iview.loadFail("");
                    }
                    @Override
                    public void onNext(RecentUpdate result) {
                        iview.loadData(result);
                    }
                });
        addSubscription(subscription);
    }

    public void getMovieMore(int page, int pagesize) {
        Subscription subscription = ApiManager
                .getRetrofitInstance()
                .getRecomend(page,pagesize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RecentUpdate>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(RecentUpdate result) {
                        iview.loadMore(result);
                    }
                });
        addSubscription(subscription);
    }

    @Override
    public void release() {
        unSubcription();
    }

}
