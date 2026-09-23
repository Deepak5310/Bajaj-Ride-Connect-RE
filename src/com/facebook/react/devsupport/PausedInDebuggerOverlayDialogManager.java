package com.facebook.react.devsupport;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.util.Supplier;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;

/* JADX INFO: loaded from: classes3.dex */
class PausedInDebuggerOverlayDialogManager implements PausedInDebuggerOverlayManager {
    private final Supplier<Context> mContextSupplier;
    private Dialog mPausedInDebuggerDialog;

    public PausedInDebuggerOverlayDialogManager(Supplier<Context> supplier) {
        this.mContextSupplier = supplier;
    }

    @Override // com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager
    public void showPausedInDebuggerOverlay(final String str, final DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPausedInDebuggerOverlay$1(str, pausedInDebuggerOverlayCommandListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPausedInDebuggerOverlay$1(String str, final DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener) {
        Dialog dialog = this.mPausedInDebuggerDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        Context context = this.mContextSupplier.get();
        if (context == null) {
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.paused_in_debugger_view, (ViewGroup) null);
        Dialog dialog2 = new Dialog(context);
        this.mPausedInDebuggerDialog = dialog2;
        dialog2.setContentView(viewInflate);
        this.mPausedInDebuggerDialog.setCancelable(false);
        ((TextView) Assertions.assertNotNull((TextView) viewInflate.findViewById(R.id.paused_text))).setText(str);
        ((View) Assertions.assertNotNull(viewInflate.findViewById(R.id.resume_button))).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                pausedInDebuggerOverlayCommandListener.onResume();
            }
        });
        Window window = this.mPausedInDebuggerDialog.getWindow();
        if (window != null) {
            window.setGravity(48);
            window.setBackgroundDrawableResource(R.drawable.paused_in_debugger_background);
        }
        this.mPausedInDebuggerDialog.show();
    }

    @Override // com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager
    public void hidePausedInDebuggerOverlay() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hidePausedInDebuggerOverlay$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hidePausedInDebuggerOverlay$2() {
        Dialog dialog = this.mPausedInDebuggerDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.mPausedInDebuggerDialog = null;
        }
    }
}
