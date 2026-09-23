package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.systrace.Systrace;
import com.google.firebase.perf.FirebasePerformance;
import com.google.maps.android.BuildConfig;

/* JADX INFO: loaded from: classes3.dex */
final class IntBufferBatchMountItem implements BatchMountItem {
    static final int INSTRUCTION_CREATE = 2;
    static final int INSTRUCTION_DELETE = 4;
    static final int INSTRUCTION_FLAG_MULTIPLE = 1;
    static final int INSTRUCTION_INSERT = 8;
    static final int INSTRUCTION_REMOVE = 16;
    static final int INSTRUCTION_REMOVE_DELETE_TREE = 2048;
    static final int INSTRUCTION_UPDATE_EVENT_EMITTER = 256;
    static final int INSTRUCTION_UPDATE_LAYOUT = 128;
    static final int INSTRUCTION_UPDATE_OVERFLOW_INSET = 1024;
    static final int INSTRUCTION_UPDATE_PADDING = 512;
    static final int INSTRUCTION_UPDATE_PROPS = 32;
    static final int INSTRUCTION_UPDATE_STATE = 64;
    static final String TAG = "IntBufferBatchMountItem";
    private final int mCommitNumber;
    private final int[] mIntBuffer;
    private final int mIntBufferLen;
    private final Object[] mObjBuffer;
    private final int mObjBufferLen;
    private final int mSurfaceId;

    IntBufferBatchMountItem(int i, int[] iArr, Object[] objArr, int i2) {
        this.mSurfaceId = i;
        this.mCommitNumber = i2;
        this.mIntBuffer = iArr;
        this.mObjBuffer = objArr;
        this.mIntBufferLen = iArr.length;
        this.mObjBufferLen = objArr.length;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        int i;
        int i2;
        long j;
        int i3;
        int i4;
        int i5;
        SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(this.mSurfaceId);
        if (surfaceManager == null) {
            FLog.e(TAG, "Skipping batch of MountItems; no SurfaceMountingManager found for [%d].", Integer.valueOf(this.mSurfaceId));
            return;
        }
        if (surfaceManager.isStopped()) {
            FLog.e(TAG, "Skipping batch of MountItems; was stopped [%d].", Integer.valueOf(this.mSurfaceId));
            return;
        }
        if (FabricUIManager.ENABLE_FABRIC_LOGS) {
            FLog.d(TAG, "Executing IntBufferBatchMountItem on surface [%d]", Integer.valueOf(this.mSurfaceId));
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < this.mIntBufferLen) {
            int[] iArr = this.mIntBuffer;
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            int i10 = i9 & (-2);
            if ((i9 & 1) != 0) {
                int i11 = iArr[i8];
                i8 = i6 + 2;
                i = i11;
            } else {
                i = 1;
            }
            long j2 = 0;
            Systrace.beginSection(0L, "IntBufferBatchMountItem::mountInstructions::" + nameForInstructionString(i10));
            int i12 = i7;
            i6 = i8;
            int i13 = 0;
            while (i13 < i) {
                if (i10 == 2) {
                    String fabricComponentName = FabricNameComponentMapping.getFabricComponentName((String) this.mObjBuffer[i12]);
                    int[] iArr2 = this.mIntBuffer;
                    int i14 = iArr2[i6];
                    Object[] objArr = this.mObjBuffer;
                    ReadableMap readableMap = (ReadableMap) objArr[i12 + 1];
                    int i15 = i12 + 3;
                    StateWrapper stateWrapper = (StateWrapper) objArr[i12 + 2];
                    i12 += 4;
                    int i16 = i6 + 2;
                    i2 = i13;
                    surfaceManager.createView(fabricComponentName, i14, readableMap, stateWrapper, (EventEmitterWrapper) objArr[i15], iArr2[i6 + 1] == 1);
                    i6 = i16;
                } else {
                    i2 = i13;
                    if (i10 == 4) {
                        surfaceManager.deleteView(this.mIntBuffer[i6]);
                        i6++;
                    } else if (i10 == 8) {
                        int[] iArr3 = this.mIntBuffer;
                        int i17 = iArr3[i6];
                        int i18 = i6 + 2;
                        int i19 = iArr3[i6 + 1];
                        i6 += 3;
                        surfaceManager.addViewAt(i19, i17, iArr3[i18]);
                    } else if (i10 == 16) {
                        int[] iArr4 = this.mIntBuffer;
                        int i20 = iArr4[i6];
                        int i21 = i6 + 2;
                        int i22 = iArr4[i6 + 1];
                        i6 += 3;
                        surfaceManager.removeViewAt(i20, i22, iArr4[i21]);
                    } else if (i10 == 2048) {
                        int[] iArr5 = this.mIntBuffer;
                        int i23 = iArr5[i6];
                        int i24 = i6 + 2;
                        int i25 = iArr5[i6 + 1];
                        i6 += 3;
                        surfaceManager.removeDeleteTreeAt(i23, i25, iArr5[i24]);
                    } else {
                        if (i10 == 32) {
                            i4 = i6 + 1;
                            i5 = i12 + 1;
                            surfaceManager.updateProps(this.mIntBuffer[i6], (ReadableMap) this.mObjBuffer[i12]);
                        } else {
                            if (i10 == 64) {
                                i4 = i6 + 1;
                                i5 = i12 + 1;
                                surfaceManager.updateState(this.mIntBuffer[i6], (StateWrapper) this.mObjBuffer[i12]);
                            } else if (i10 == 128) {
                                int[] iArr6 = this.mIntBuffer;
                                int i26 = iArr6[i6];
                                int i27 = iArr6[i6 + 1];
                                int i28 = iArr6[i6 + 2];
                                int i29 = iArr6[i6 + 3];
                                int i30 = iArr6[i6 + 4];
                                int i31 = iArr6[i6 + 5];
                                int i32 = i6 + 7;
                                int i33 = iArr6[i6 + 6];
                                if (ReactNativeFeatureFlags.setAndroidLayoutDirection()) {
                                    j = 0;
                                    surfaceManager.updateLayout(i26, i27, i28, i29, i30, i31, i33, this.mIntBuffer[i32]);
                                    i32 = i6 + 8;
                                } else {
                                    j = 0;
                                    surfaceManager.updateLayout(i26, i27, i28, i29, i30, i31, i33, 0);
                                }
                                i6 = i32;
                            } else {
                                j = 0;
                                if (i10 == 512) {
                                    int[] iArr7 = this.mIntBuffer;
                                    i3 = i6 + 5;
                                    surfaceManager.updatePadding(iArr7[i6], iArr7[i6 + 1], iArr7[i6 + 2], iArr7[i6 + 3], iArr7[i6 + 4]);
                                } else if (i10 == 1024) {
                                    int[] iArr8 = this.mIntBuffer;
                                    i3 = i6 + 5;
                                    surfaceManager.updateOverflowInset(iArr8[i6], iArr8[i6 + 1], iArr8[i6 + 2], iArr8[i6 + 3], iArr8[i6 + 4]);
                                } else if (i10 == 256) {
                                    surfaceManager.updateEventEmitter(this.mIntBuffer[i6], (EventEmitterWrapper) this.mObjBuffer[i12]);
                                    i6++;
                                    i12++;
                                } else {
                                    throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i10 + " at index: " + i6);
                                }
                                i6 = i3;
                            }
                            i13 = i2 + 1;
                            j2 = j;
                        }
                        i6 = i4;
                        i12 = i5;
                    }
                }
                j = 0;
                i13 = i2 + 1;
                j2 = j;
            }
            Systrace.endSection(j2);
            i7 = i12;
        }
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.BatchMountItem
    public boolean isBatchEmpty() {
        return this.mIntBufferLen == 0;
    }

    public String toString() {
        int i;
        int i2;
        int i3;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("IntBufferBatchMountItem [surface:%d]:\n", Integer.valueOf(this.mSurfaceId)));
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.mIntBufferLen) {
                int[] iArr = this.mIntBuffer;
                int i6 = i4 + 1;
                int i7 = iArr[i4];
                int i8 = i7 & (-2);
                int i9 = 1;
                if ((i7 & 1) != 0) {
                    i9 = iArr[i6];
                    i6 = i4 + 2;
                }
                i4 = i6;
                for (int i10 = 0; i10 < i9; i10++) {
                    if (i8 == 2) {
                        String fabricComponentName = FabricNameComponentMapping.getFabricComponentName((String) this.mObjBuffer[i5]);
                        i5 += 4;
                        int i11 = i4 + 1;
                        Integer numValueOf = Integer.valueOf(this.mIntBuffer[i4]);
                        i4 += 2;
                        sb.append(String.format("CREATE [%d] - layoutable:%d - %s\n", numValueOf, Integer.valueOf(this.mIntBuffer[i11]), fabricComponentName));
                    } else {
                        if (i8 == 4) {
                            i = i4 + 1;
                            sb.append(String.format("DELETE [%d]\n", Integer.valueOf(this.mIntBuffer[i4])));
                        } else if (i8 == 8) {
                            Integer numValueOf2 = Integer.valueOf(this.mIntBuffer[i4]);
                            int i12 = i4 + 2;
                            Integer numValueOf3 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                            i4 += 3;
                            sb.append(String.format("INSERT [%d]->[%d] @%d\n", numValueOf2, numValueOf3, Integer.valueOf(this.mIntBuffer[i12])));
                        } else if (i8 == 16) {
                            Integer numValueOf4 = Integer.valueOf(this.mIntBuffer[i4]);
                            int i13 = i4 + 2;
                            Integer numValueOf5 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                            i4 += 3;
                            sb.append(String.format("REMOVE [%d]->[%d] @%d\n", numValueOf4, numValueOf5, Integer.valueOf(this.mIntBuffer[i13])));
                        } else if (i8 == 2048) {
                            Integer numValueOf6 = Integer.valueOf(this.mIntBuffer[i4]);
                            int i14 = i4 + 2;
                            Integer numValueOf7 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                            i4 += 3;
                            sb.append(String.format("REMOVE+DELETE TREE [%d]->[%d] @%d\n", numValueOf6, numValueOf7, Integer.valueOf(this.mIntBuffer[i14])));
                        } else {
                            if (i8 == 32) {
                                i2 = i5 + 1;
                                Object obj = this.mObjBuffer[i5];
                                i3 = i4 + 1;
                                sb.append(String.format("UPDATE PROPS [%d]: %s\n", Integer.valueOf(this.mIntBuffer[i4]), "<hidden>"));
                            } else if (i8 == 64) {
                                i2 = i5 + 1;
                                i3 = i4 + 1;
                                sb.append(String.format("UPDATE STATE [%d]: %s\n", Integer.valueOf(this.mIntBuffer[i4]), "<hidden>"));
                            } else if (i8 == 128) {
                                int[] iArr2 = this.mIntBuffer;
                                int i15 = iArr2[i4];
                                Integer numValueOf8 = Integer.valueOf(iArr2[i4 + 1]);
                                Integer numValueOf9 = Integer.valueOf(i15);
                                Integer numValueOf10 = Integer.valueOf(this.mIntBuffer[i4 + 2]);
                                Integer numValueOf11 = Integer.valueOf(this.mIntBuffer[i4 + 3]);
                                Integer numValueOf12 = Integer.valueOf(this.mIntBuffer[i4 + 4]);
                                int i16 = i4 + 6;
                                Integer numValueOf13 = Integer.valueOf(this.mIntBuffer[i4 + 5]);
                                i4 += 7;
                                sb.append(String.format("UPDATE LAYOUT [%d]->[%d]: x:%d y:%d w:%d h:%d displayType:%d\n", numValueOf8, numValueOf9, numValueOf10, numValueOf11, numValueOf12, numValueOf13, Integer.valueOf(this.mIntBuffer[i16])));
                            } else if (i8 == 512) {
                                Integer numValueOf14 = Integer.valueOf(this.mIntBuffer[i4]);
                                Integer numValueOf15 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                                Integer numValueOf16 = Integer.valueOf(this.mIntBuffer[i4 + 2]);
                                int i17 = i4 + 4;
                                Integer numValueOf17 = Integer.valueOf(this.mIntBuffer[i4 + 3]);
                                i4 += 5;
                                sb.append(String.format("UPDATE PADDING [%d]: top:%d right:%d bottom:%d left:%d\n", numValueOf14, numValueOf15, numValueOf16, numValueOf17, Integer.valueOf(this.mIntBuffer[i17])));
                            } else if (i8 == 1024) {
                                Integer numValueOf18 = Integer.valueOf(this.mIntBuffer[i4]);
                                Integer numValueOf19 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                                Integer numValueOf20 = Integer.valueOf(this.mIntBuffer[i4 + 2]);
                                int i18 = i4 + 4;
                                Integer numValueOf21 = Integer.valueOf(this.mIntBuffer[i4 + 3]);
                                i4 += 5;
                                sb.append(String.format("UPDATE OVERFLOWINSET [%d]: left:%d top:%d right:%d bottom:%d\n", numValueOf18, numValueOf19, numValueOf20, numValueOf21, Integer.valueOf(this.mIntBuffer[i18])));
                            } else if (i8 == 256) {
                                i5++;
                                i = i4 + 1;
                                sb.append(String.format("UPDATE EVENTEMITTER [%d]\n", Integer.valueOf(this.mIntBuffer[i4])));
                            } else {
                                FLog.e(TAG, "String so far: " + sb.toString());
                                throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i8 + " at index: " + i4);
                            }
                            i5 = i2;
                            i4 = i3;
                        }
                        i4 = i;
                    }
                }
            }
            return sb.toString();
        } catch (Exception e) {
            FLog.e(TAG, "Caught exception trying to print", e);
            StringBuilder sb2 = new StringBuilder();
            for (int i19 = 0; i19 < this.mIntBufferLen; i19++) {
                sb2.append(this.mIntBuffer[i19]);
                sb2.append(", ");
            }
            FLog.e(TAG, sb2.toString());
            for (int i20 = 0; i20 < this.mObjBufferLen; i20++) {
                String str = TAG;
                Object obj2 = this.mObjBuffer[i20];
                FLog.e(str, obj2 != null ? obj2.toString() : BuildConfig.TRAVIS);
            }
            return "";
        }
    }

    private static String nameForInstructionString(int i) {
        if (i == 2) {
            return "CREATE";
        }
        if (i == 4) {
            return FirebasePerformance.HttpMethod.DELETE;
        }
        if (i == 8) {
            return "INSERT";
        }
        if (i == 16) {
            return "REMOVE";
        }
        if (i == 2048) {
            return "REMOVE_DELETE_TREE";
        }
        if (i == 32) {
            return "UPDATE_PROPS";
        }
        if (i == 64) {
            return "UPDATE_STATE";
        }
        if (i == 128) {
            return "UPDATE_LAYOUT";
        }
        if (i == 512) {
            return "UPDATE_PADDING";
        }
        if (i == 1024) {
            return "UPDATE_OVERFLOW_INSET";
        }
        if (i == 256) {
            return "UPDATE_EVENT_EMITTER";
        }
        return "UNKNOWN";
    }
}
