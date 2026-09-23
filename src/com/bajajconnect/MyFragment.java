package com.bajajconnect;

import android.location.Location;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bajajconnect.ble.BleFeatures;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.ui.navigation.NavigationCallback;
import com.mappls.sdk.navigation.ui.navigation.NavigationView;
import com.mappls.sdk.navigation.ui.navigation.NavigationViewCallback;
import java.util.Objects;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes3.dex */
public class MyFragment extends Fragment implements NavigationCallback, NavigationViewCallback {
    private AdviseInfo adviseInfo;
    private final Boolean isDarkMood;
    private final MyViewManager manager;
    private NavigationView navigationView;
    ReactContext reactContext;
    private View view;
    private final String TAG = MyViewManager.REACT_CLASS;
    private final TimerUtils datePusherTimer = new TimerUtils();
    private final long HOUR_IN_MS = DateUtils.MILLIS_PER_HOUR;
    private final Integer testInt = 0;

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationViewCallback
    public void onNavigationMapReady(MapplsMap mapplsMap) {
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onNewRoute(String str) {
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onWayPointReached(WayPoint wayPoint) {
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationViewCallback
    public void searchAlongRoute() {
    }

    public MyFragment(ReactContext reactContext, MyViewManager myViewManager, Boolean bool) {
        this.reactContext = reactContext;
        this.manager = myViewManager;
        this.isDarkMood = bool;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.adviseInfo = null;
        if (this.isDarkMood.booleanValue()) {
            this.view = layoutInflater.inflate(R.layout.activity_navigation_ui_dark, viewGroup, false);
        } else {
            this.view = layoutInflater.inflate(R.layout.activity_navigation_ui, viewGroup, false);
        }
        return this.view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        NavigationView navigationView = (NavigationView) getView().findViewById(R.id.navigation_view);
        this.navigationView = navigationView;
        if (navigationView != null) {
            navigationView.onCreate(bundle);
            this.navigationView.setNavigationViewCallback(this);
            this.navigationView.setOnNavigationCallback(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.navigationView.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.navigationView.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        NavigationView navigationView = this.navigationView;
        if (navigationView != null) {
            navigationView.onDestroy();
        }
        this.datePusherTimer.stopTimer();
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onNavigationStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.navigationView.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.navigationView.onStop();
        this.datePusherTimer.stopTimer();
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onNavigationStarted() {
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onNavigationStart();
        }
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onNavigationCancelled() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", "endTrip");
        MyViewManager myViewManager = this.manager;
        if (myViewManager != null) {
            myViewManager.pushEvent(this.view, "onUpdate", writableMapCreateMap);
        }
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onNavigationStop();
        }
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onRouteProgress(AdviseInfo adviseInfo) {
        if (adviseInfo != null) {
            this.adviseInfo = adviseInfo;
            if (!this.datePusherTimer.isTimerRunning()) {
                this.datePusherTimer.startTimer(DateUtils.MILLIS_PER_HOUR);
            }
            if (BleFeatures.navigationCallback != null) {
                BleFeatures.navigationCallback.onNavigationProgress(adviseInfo);
            }
        }
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onNavigationFinished() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", "onNavigationFinished");
        MyViewManager myViewManager = this.manager;
        if (myViewManager != null) {
            myViewManager.pushEvent(this.view, "onUpdate", writableMapCreateMap);
        }
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onDestinationReached();
        }
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationViewCallback
    public void onNavigationEnd() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", "onNavigationEnd");
        MyViewManager myViewManager = this.manager;
        if (myViewManager != null) {
            myViewManager.pushEvent(this.view, "onUpdate", writableMapCreateMap);
        }
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onNavigationStop();
        }
    }

    public void sendDataToNative() {
        if (this.adviseInfo != null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("type", "update");
            writableMapCreateMap.putString("fullText", this.adviseInfo.getText());
            writableMapCreateMap.putString("shortText", this.adviseInfo.getShortText());
            writableMapCreateMap.putString("nextInstructionText", this.adviseInfo.getNextInstructionText());
            writableMapCreateMap.putInt("distanceToNextAdvise", this.adviseInfo.getDistanceToNextAdvise());
            writableMapCreateMap.putString("eta", this.adviseInfo.getEta());
            writableMapCreateMap.putDouble("eatSeconds", this.adviseInfo.getLeftTime());
            writableMapCreateMap.putDouble("distanceLeft", this.adviseInfo.getLeftDistance());
            writableMapCreateMap.putDouble("maneuverID", this.adviseInfo.getManeuverID());
            writableMapCreateMap.putString("logString", this.adviseInfo.toString());
            WritableArray writableArrayCreateArray = Arguments.createArray();
            writableArrayCreateArray.pushDouble(((Location) Objects.requireNonNull(this.adviseInfo.getLocation())).getLongitude());
            writableArrayCreateArray.pushDouble(((Location) Objects.requireNonNull(this.adviseInfo.getLocation())).getLatitude());
            writableMapCreateMap.putArray("currentLocation", writableArrayCreateArray);
            MyViewManager myViewManager = this.manager;
            if (myViewManager != null) {
                myViewManager.pushEvent(this.view, "onUpdate", writableMapCreateMap);
            }
        }
    }

    public class TimerUtils {
        private CountDownTimer countDownTimer;

        public TimerUtils() {
        }

        public void startTimer(long j) {
            CountDownTimer countDownTimer = new CountDownTimer(j, 500L) { // from class: com.bajajconnect.MyFragment.TimerUtils.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    MyFragment.this.sendDataToNative();
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    TimerUtils.this.performActionAfterTimer();
                }
            };
            this.countDownTimer = countDownTimer;
            countDownTimer.start();
        }

        public void resetTimer(long j) {
            CountDownTimer countDownTimer = this.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.countDownTimer = null;
            }
            startTimer(j);
        }

        public boolean isTimerRunning() {
            return this.countDownTimer != null;
        }

        public void stopTimer() {
            CountDownTimer countDownTimer = this.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.countDownTimer = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void performActionAfterTimer() {
            Log.d(MyViewManager.REACT_CLASS, "performActionAfterTimer: over");
        }
    }
}
