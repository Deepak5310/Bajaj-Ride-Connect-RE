package com.bajajconnect.gMaps;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bajajconnect.ble.BleFeatures;
import com.google.android.libraries.mapsplatform.turnbyturn.TurnByTurnManager;
import com.google.android.libraries.mapsplatform.turnbyturn.model.NavInfo;

/* JADX INFO: loaded from: classes3.dex */
public class NavInfoReceivingService extends Service {
    private static final MutableLiveData<NavInfo> navInfoMutableLiveData = new MutableLiveData<>();
    private HandlerThread handlerThread;
    private Messenger incomingMessenger;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("NavInfoReceivingService");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.incomingMessenger = new Messenger(new IncomingNavStepHandler(this.handlerThread.getLooper()));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.incomingMessenger.getBinder();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        navInfoMutableLiveData.postValue(null);
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.handlerThread.quitSafely();
    }

    private static class IncomingNavStepHandler extends Handler {
        private final TurnByTurnManager turnByTurnManager;

        public IncomingNavStepHandler(Looper looper) {
            super(looper);
            this.turnByTurnManager = TurnByTurnManager.createInstance();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 7200) {
                NavInfo navInfoFromBundle = this.turnByTurnManager.readNavInfoFromBundle(message.getData());
                Log.e("NavInfoService", "tbt " + String.valueOf(navInfoFromBundle));
                try {
                    BleFeatures.navigationCallback.onNavigationProgress(null, navInfoFromBundle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                NavInfoReceivingService.navInfoMutableLiveData.postValue(navInfoFromBundle);
            }
        }
    }

    public static LiveData<NavInfo> getNavInfoLiveData() {
        return navInfoMutableLiveData;
    }
}
