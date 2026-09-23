package com.facebook.react.views.debuggingoverlay;

import android.graphics.RectF;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UnexpectedNativeTypeException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebuggingOverlayManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = DebuggingOverlayManager.REACT_CLASS)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/views/debuggingoverlay/DebuggingOverlayManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/facebook/react/views/debuggingoverlay/DebuggingOverlay;", "()V", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getName", "", "receiveCommand", "", "view", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DebuggingOverlayManager extends SimpleViewManager<DebuggingOverlay> {
    public static final String REACT_CLASS = "DebuggingOverlay";

    /* JADX WARN: Code duplicated, block: B:106:0x0195 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0178  */
    /* JADX WARN: Code duplicated, block: B:73:0x017a  */
    /* JADX WARN: Code duplicated, block: B:75:0x017e  */
    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(DebuggingOverlay view, String commandId, ReadableArray args) throws Exception {
        boolean z;
        String str;
        String str2;
        int i;
        boolean z2;
        String str3;
        ReadableArray readableArray;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        int iHashCode = commandId.hashCode();
        String str6 = REACT_CLASS;
        if (iHashCode != -1942063165) {
            String str7 = "width";
            String str8 = "y";
            String str9 = "x";
            if (iHashCode == 1326903961) {
                String str10 = "x";
                if (commandId.equals("highlightTraceUpdates")) {
                    if (args == null) {
                        return;
                    }
                    boolean z3 = false;
                    ReadableArray array = args.getArray(0);
                    ArrayList arrayList = new ArrayList();
                    int size = array.size();
                    int i2 = 0;
                    boolean z4 = true;
                    while (true) {
                        if (i2 >= size) {
                            z = z4;
                            break;
                        }
                        ReadableMap map = array.getMap(i2);
                        ReadableMap map2 = map.getMap("rectangle");
                        if (map2 == null) {
                            ReactSoftExceptionLogger.logSoftException(str6, new ReactNoCrashSoftException("Unexpected payload for highlighting trace updates: rectangle field is null"));
                            z = z3;
                            break;
                        }
                        int i3 = map.getInt("id");
                        int i4 = map.getInt("color");
                        arrayList = arrayList;
                        String str11 = str10;
                        try {
                            float f = (float) map2.getDouble(str11);
                            str10 = str11;
                            try {
                                float f2 = (float) map2.getDouble("y");
                                str = str6;
                                try {
                                    str2 = str7;
                                    i = size;
                                    try {
                                        arrayList = arrayList;
                                        try {
                                            arrayList.add(new TraceUpdate(i3, new RectF(PixelUtil.toPixelFromDIP(f), PixelUtil.toPixelFromDIP(f2), PixelUtil.toPixelFromDIP((float) (((double) f) + map2.getDouble(str7))), PixelUtil.toPixelFromDIP((float) (((double) f2) + map2.getDouble("height")))), i4));
                                            str3 = str;
                                        } catch (Exception e) {
                                            e = e;
                                            if (e instanceof NoSuchKeyException) {
                                                z2 = true;
                                            } else {
                                                z2 = e instanceof UnexpectedNativeTypeException;
                                            }
                                            if (z2) {
                                                str3 = str;
                                                ReactSoftExceptionLogger.logSoftException(str3, new ReactNoCrashSoftException("Unexpected payload for highlighting trace updates: rectangle field should have x, y, width, height fields"));
                                                z4 = false;
                                            } else {
                                                throw e;
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        arrayList = arrayList;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    str2 = str7;
                                    i = size;
                                    if (e instanceof NoSuchKeyException) {
                                        z2 = true;
                                    } else {
                                        z2 = e instanceof UnexpectedNativeTypeException;
                                    }
                                    if (z2) {
                                        str3 = str;
                                        ReactSoftExceptionLogger.logSoftException(str3, new ReactNoCrashSoftException("Unexpected payload for highlighting trace updates: rectangle field should have x, y, width, height fields"));
                                        z4 = false;
                                        i2++;
                                        str7 = str2;
                                        size = i;
                                        str6 = str3;
                                        z3 = false;
                                    } else {
                                        throw e;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                str = str6;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            arrayList = arrayList;
                            str = str6;
                            str2 = str7;
                            i = size;
                            str10 = str11;
                        }
                        i2++;
                        str7 = str2;
                        size = i;
                        str6 = str3;
                        z3 = false;
                    }
                    if (z) {
                        view.setTraceUpdates(arrayList);
                        return;
                    }
                    return;
                }
            } else if (iHashCode == 1385348555 && commandId.equals("highlightElements")) {
                if (args == null) {
                    return;
                }
                ReadableArray array2 = args.getArray(0);
                ArrayList arrayList2 = new ArrayList();
                int size2 = array2.size();
                int i5 = 0;
                boolean z5 = true;
                while (i5 < size2) {
                    ReadableMap map3 = array2.getMap(i5);
                    try {
                        float f3 = (float) map3.getDouble(str9);
                        float f4 = (float) map3.getDouble(str8);
                        str4 = str8;
                        str5 = str9;
                        try {
                            readableArray = array2;
                            try {
                                arrayList2.add(new RectF(PixelUtil.toPixelFromDIP(f3), PixelUtil.toPixelFromDIP(f4), PixelUtil.toPixelFromDIP((float) (((double) f3) + map3.getDouble("width"))), PixelUtil.toPixelFromDIP((float) (((double) f4) + map3.getDouble("height")))));
                            } catch (Exception e6) {
                                e = e6;
                                if (e instanceof NoSuchKeyException ? true : e instanceof UnexpectedNativeTypeException) {
                                    ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Unexpected payload for highlighting elements: every element should have x, y, width, height fields"));
                                    z5 = false;
                                } else {
                                    throw e;
                                }
                            }
                        } catch (Exception e7) {
                            e = e7;
                            readableArray = array2;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        readableArray = array2;
                        str4 = str8;
                        str5 = str9;
                    }
                    i5++;
                    array2 = readableArray;
                    str8 = str4;
                    str9 = str5;
                }
                if (z5) {
                    view.setHighlightedElementsRectangles(arrayList2);
                    return;
                }
                return;
            }
        } else if (commandId.equals("clearElementsHighlights")) {
            view.clearElementsHighlights();
            return;
        }
        ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Received unexpected command in DebuggingOverlayManager"));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public DebuggingOverlay createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DebuggingOverlay(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }
}
