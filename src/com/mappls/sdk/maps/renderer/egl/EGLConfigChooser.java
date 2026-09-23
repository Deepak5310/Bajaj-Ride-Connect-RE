package com.mappls.sdk.maps.renderer.egl;

import android.opengl.GLSurfaceView;
import android.os.Build;
import androidx.core.os.EnvironmentCompat;
import com.mappls.sdk.maps.constants.MapplsConstants;
import com.mappls.sdk.maps.log.Logger;
import com.mappls.sdk.maps.utils.Compare;
import java.util.ArrayList;
import java.util.Collections;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes4.dex */
public class EGLConfigChooser implements GLSurfaceView.EGLConfigChooser {
    private static final int EGL_CONFORMANT = 12354;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static final String TAG = "Mbgl-EGLConfigChooser";
    private boolean translucentSurface;

    public EGLConfigChooser() {
        this(false);
    }

    public EGLConfigChooser(boolean z) {
        this.translucentSurface = z;
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] configAttributes = getConfigAttributes();
        int[] numberOfConfigurations = getNumberOfConfigurations(egl10, eGLDisplay, configAttributes);
        if (numberOfConfigurations[0] < 1) {
            Logger.e(TAG, "eglChooseConfig() returned no configs.");
        }
        EGLConfig eGLConfigChooseBestMatchConfig = chooseBestMatchConfig(egl10, eGLDisplay, getPossibleConfigurations(egl10, eGLDisplay, configAttributes, numberOfConfigurations));
        if (eGLConfigChooseBestMatchConfig == null) {
            Logger.e(TAG, "No config chosen");
        }
        return eGLConfigChooseBestMatchConfig;
    }

    private int[] getNumberOfConfigurations(EGL10 egl10, EGLDisplay eGLDisplay, int[] iArr) {
        int[] iArr2 = new int[1];
        if (!egl10.eglChooseConfig(eGLDisplay, iArr, null, 0, iArr2)) {
            Logger.e(TAG, String.format(MapplsConstants.MAPPLS_LOCALE, "eglChooseConfig(NULL) returned error %d", Integer.valueOf(egl10.eglGetError())));
        }
        return iArr2;
    }

    private EGLConfig[] getPossibleConfigurations(EGL10 egl10, EGLDisplay eGLDisplay, int[] iArr, int[] iArr2) {
        int i = iArr2[0];
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        if (!egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2)) {
            Logger.e(TAG, String.format(MapplsConstants.MAPPLS_LOCALE, "eglChooseConfig() returned error %d", Integer.valueOf(egl10.eglGetError())));
        }
        return eGLConfigArr;
    }

    enum BufferFormat {
        Format16Bit(3),
        Format32BitNoAlpha(1),
        Format32BitAlpha(2),
        Format24Bit(0),
        Unknown(4);

        int value;

        BufferFormat(int i) {
            this.value = i;
        }
    }

    enum DepthStencilFormat {
        Format16Depth8Stencil(1),
        Format24Depth8Stencil(0);

        int value;

        DepthStencilFormat(int i) {
            this.value = i;
        }
    }

    private EGLConfig chooseBestMatchConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        BufferFormat bufferFormat;
        DepthStencilFormat depthStencilFormat;
        EGLConfig[] eGLConfigArr2 = eGLConfigArr;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (int length = eGLConfigArr2.length; i2 < length; length = length) {
            EGLConfig eGLConfig = eGLConfigArr2[i2];
            if (eGLConfig != null) {
                int i3 = i + 1;
                int configAttr = getConfigAttr(egl10, eGLDisplay, eGLConfig, 12327);
                int configAttr2 = getConfigAttr(egl10, eGLDisplay, eGLConfig, EGL_CONFORMANT);
                int configAttr3 = getConfigAttr(egl10, eGLDisplay, eGLConfig, 12320);
                int configAttr4 = getConfigAttr(egl10, eGLDisplay, eGLConfig, 12324);
                int configAttr5 = getConfigAttr(egl10, eGLDisplay, eGLConfig, 12323);
                int configAttr6 = getConfigAttr(egl10, eGLDisplay, eGLConfig, 12322);
                int configAttr7 = getConfigAttr(egl10, eGLDisplay, eGLConfig, 12321);
                getConfigAttr(egl10, eGLDisplay, eGLConfig, 12350);
                int configAttr8 = getConfigAttr(egl10, eGLDisplay, eGLConfig, 12325);
                int configAttr9 = getConfigAttr(egl10, eGLDisplay, eGLConfig, 12326);
                if ((configAttr8 == 24 || configAttr8 == 16) & (configAttr9 == 8) & (getConfigAttr(egl10, eGLDisplay, eGLConfig, 12338) == 0) & (getConfigAttr(egl10, eGLDisplay, eGLConfig, 12337) == 0)) {
                    if (configAttr3 == 16 && configAttr4 == 5 && configAttr5 == 6 && configAttr6 == 5 && configAttr7 == 0) {
                        bufferFormat = BufferFormat.Format16Bit;
                    } else if (configAttr3 == 32 && configAttr4 == 8 && configAttr5 == 8 && configAttr6 == 8 && configAttr7 == 0) {
                        bufferFormat = BufferFormat.Format32BitNoAlpha;
                    } else if (configAttr3 == 32 && configAttr4 == 8 && configAttr5 == 8 && configAttr6 == 8 && configAttr7 == 8) {
                        bufferFormat = BufferFormat.Format32BitAlpha;
                    } else if (configAttr3 == 24 && configAttr4 == 8 && configAttr5 == 8 && configAttr6 == 8 && configAttr7 == 0) {
                        bufferFormat = BufferFormat.Format24Bit;
                    } else {
                        bufferFormat = BufferFormat.Unknown;
                    }
                    if (configAttr8 == 16 && configAttr9 == 8) {
                        depthStencilFormat = DepthStencilFormat.Format16Depth8Stencil;
                    } else {
                        depthStencilFormat = DepthStencilFormat.Format24Depth8Stencil;
                    }
                    boolean z = (configAttr2 & 4) != 4;
                    boolean z2 = configAttr != 12344;
                    if (bufferFormat != BufferFormat.Unknown) {
                        arrayList.add(new Comparable<C1Config>(bufferFormat, depthStencilFormat, z, z2, i3, eGLConfig) { // from class: com.mappls.sdk.maps.renderer.egl.EGLConfigChooser.1Config
                            private final BufferFormat bufferFormat;
                            private final EGLConfig config;
                            private final DepthStencilFormat depthStencilFormat;
                            private final int index;
                            private final boolean isCaveat;
                            private final boolean isNotConformant;

                            {
                                this.bufferFormat = bufferFormat;
                                this.depthStencilFormat = depthStencilFormat;
                                this.isNotConformant = z;
                                this.isCaveat = z2;
                                this.index = i3;
                                this.config = eGLConfig;
                            }

                            @Override // java.lang.Comparable
                            public int compareTo(C1Config c1Config) {
                                int iCompare = Compare.compare(this.bufferFormat.value, c1Config.bufferFormat.value);
                                if (iCompare != 0) {
                                    return iCompare;
                                }
                                int iCompare2 = Compare.compare(this.depthStencilFormat.value, c1Config.depthStencilFormat.value);
                                if (iCompare2 != 0) {
                                    return iCompare2;
                                }
                                int iCompare3 = Compare.compare(this.isNotConformant, c1Config.isNotConformant);
                                if (iCompare3 != 0) {
                                    return iCompare3;
                                }
                                int iCompare4 = Compare.compare(this.isCaveat, c1Config.isCaveat);
                                if (iCompare4 != 0) {
                                    return iCompare4;
                                }
                                int iCompare5 = Compare.compare(this.index, c1Config.index);
                                if (iCompare5 != 0) {
                                    return iCompare5;
                                }
                                return 0;
                            }
                        });
                    }
                }
                i = i3;
            }
            i2++;
            eGLConfigArr2 = eGLConfigArr;
        }
        Collections.sort(arrayList);
        if (arrayList.size() == 0) {
            Logger.e(TAG, "No matching configurations after filtering");
            return null;
        }
        C1Config c1Config = (C1Config) arrayList.get(0);
        if (c1Config.isCaveat) {
            Logger.w(TAG, "Chosen config has a caveat.");
        }
        if (c1Config.isNotConformant) {
            Logger.w(TAG, "Chosen config is not conformant.");
        }
        return c1Config.config;
    }

    private int getConfigAttr(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
        int[] iArr = new int[1];
        if (!egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr)) {
            Logger.e(TAG, String.format(MapplsConstants.MAPPLS_LOCALE, "eglGetConfigAttrib(%d) returned error %d", Integer.valueOf(i), Integer.valueOf(egl10.eglGetError())));
        }
        return iArr[0];
    }

    private int[] getConfigAttributes() {
        boolean z = inEmulator() || inGenymotion();
        Logger.i(TAG, String.format("In emulator: %s", Boolean.valueOf(z)));
        return new int[]{12327, 12344, 12339, 4, 12320, 16, 12324, 5, 12323, 6, 12322, 5, 12321, this.translucentSurface ? 8 : 0, 12325, 16, 12326, 8, z ? 12344 : EGL_CONFORMANT, 4, z ? 12344 : 12351, 12430, 12352, 4, 12344};
    }

    private boolean inEmulator() {
        return Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith(EnvironmentCompat.MEDIA_UNKNOWN) || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT) || System.getProperty("ro.kernel.qemu") != null;
    }

    private boolean inGenymotion() {
        return Build.MANUFACTURER.contains("Genymotion");
    }
}
