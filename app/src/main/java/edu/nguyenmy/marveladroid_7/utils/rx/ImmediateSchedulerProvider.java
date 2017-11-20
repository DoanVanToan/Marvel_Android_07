package edu.nguyenmy.marveladroid_7.utils.rx;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * Created by DELL on 11/20/2017.
 */

public class ImmediateSchedulerProvider implements BaseSchedulerProvider {
    @NonNull
    @Override
    public Scheduler io() {
        return null;
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return null;
    }
}
