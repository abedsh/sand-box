package com.codefish.sandbox;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by abedch on 10/23/2017.
 */

public class App extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();


        Set<RequestListener> requestListeners = new HashSet<>();
        requestListeners.add(new RequestLoggingListener());
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                // other setters
                .setRequestListeners(requestListeners)
                .build();
        Fresco.initialize(this, config);
        FLog.setMinimumLoggingLevel(FLog.VERBOSE);

    }
}
