package com.google.android.libraries.navigation.internal.ld;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.libraries.navigation.internal.le.ai;
import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p extends Activity implements DialogInterface.OnCancelListener {
    protected int a = 0;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void a() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get(CloudMessagingReceiver.IntentKeys.PENDING_INTENT);
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            finish();
            return;
        }
        AlertDialog alertDialogCreate = null;
        if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                this.a = 1;
                return;
            } catch (ActivityNotFoundException unused) {
                if (extras.getBoolean("notify_manager", true)) {
                    ai.c(this).e(new com.google.android.libraries.navigation.internal.lc.a(22, null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    pendingIntent.toString();
                }
                this.a = 1;
                finish();
                return;
            } catch (IntentSender.SendIntentException unused2) {
                finish();
                return;
            }
        }
        be.j(num);
        int iIntValue = num.intValue();
        com.google.android.libraries.navigation.internal.lc.h hVar = com.google.android.libraries.navigation.internal.lc.h.a;
        com.google.android.libraries.navigation.internal.lh.v vVar = new com.google.android.libraries.navigation.internal.lh.v(hVar.g(this, iIntValue, "d"), this);
        if (iIntValue != 0) {
            TypedValue typedValue = new TypedValue();
            getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
            AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(this, 5) : null;
            if (builder == null) {
                builder = new AlertDialog.Builder(this);
            }
            builder.setMessage(com.google.android.libraries.navigation.internal.lh.q.c(this, iIntValue));
            builder.setOnCancelListener(this);
            String strB = com.google.android.libraries.navigation.internal.lh.q.b(this, iIntValue);
            if (strB != null) {
                builder.setPositiveButton(strB, vVar);
            }
            String strD = com.google.android.libraries.navigation.internal.lh.q.d(this, iIntValue);
            if (strD != null) {
                builder.setTitle(strD);
            }
            new IllegalArgumentException();
            alertDialogCreate = builder.create();
        }
        if (alertDialogCreate != null) {
            hVar.a(this, alertDialogCreate, GooglePlayServicesUtil.GMS_ERROR_DIALOG, this);
        }
        this.a = 1;
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.a = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                ai aiVarC = ai.c(this);
                if (i2 == -1) {
                    Handler handler = aiVarC.p;
                    handler.sendMessage(handler.obtainMessage(3));
                } else if (i2 == 0) {
                    aiVarC.e(new com.google.android.libraries.navigation.internal.lc.a(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i == 2) {
            this.a = 0;
            setResult(i2, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.a = bundle.getInt("resolution");
        }
        if (this.a != 1) {
            a();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.a);
        super.onSaveInstanceState(bundle);
    }
}
