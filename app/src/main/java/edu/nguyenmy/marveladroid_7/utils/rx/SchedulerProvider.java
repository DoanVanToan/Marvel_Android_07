package edu.nguyenmy.marveladroid_7.utils.rx;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Scheduler;

/**
 * Created by DELL on 11/20/2017.
 */

public class SchedulerProvider implements BaseSchedulerProvider {
    @Nullable
    private static SchedulerProvider mInstance;

    // Prevent direct instantiation.
    private SchedulerProvider() {
    }

    public static synchronized SchedulerProvider getInstance() {
        if (mInstance == null) {
            mInstance = new SchedulerProvider();
        }
        return mInstance;
    }

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
