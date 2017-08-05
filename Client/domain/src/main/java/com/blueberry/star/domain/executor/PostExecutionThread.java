package com.blueberry.star.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by blueberry on 8/5/2017.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
