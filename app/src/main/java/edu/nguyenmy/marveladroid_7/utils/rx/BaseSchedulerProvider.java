package edu.nguyenmy.marveladroid_7.utils.rx;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * Created by DELL on 11/20/2017.
 */

public interface BaseSchedulerProvider {
    @NonNull
    Scheduler io();
    @NonNull
    Scheduler ui();
}
