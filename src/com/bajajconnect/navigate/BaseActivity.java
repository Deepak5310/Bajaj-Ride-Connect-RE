package com.bajajconnect.navigate;

import android.os.Bundle;
import android.widget.ProgressBar;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bajajconnect.R;
import com.mappls.sdk.navigation.activities.MapActivity;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseActivity extends MapActivity {
    private AlertDialog mProgressDialog;
    FragmentManager manager;
    private boolean safeToPerformFragmentTransactions = true;

    @Override // com.mappls.sdk.navigation.activities.MapActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void navigateTo(Fragment fragment, boolean z) {
        try {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            this.manager = supportFragmentManager;
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
            if (z) {
                try {
                    fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getSimpleName());
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            this.manager.executePendingTransactions();
        } catch (Exception e2) {
            Timber.e(e2);
        }
    }

    public void popToBackStack(Fragment fragment) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack(fragment.getClass().getSimpleName(), 1);
        }
    }

    public void addFragment(Fragment fragment, boolean z) {
        try {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            this.manager = supportFragmentManager;
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.add(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
            if (z) {
                try {
                    fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getSimpleName());
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            this.manager.executePendingTransactions();
        } catch (Exception e2) {
            Timber.e(e2);
        }
    }

    public void showProgress() {
        if (this.safeToPerformFragmentTransactions && !isProgressVisible()) {
            ProgressBar progressBar = new ProgressBar(this);
            progressBar.setIndeterminate(true);
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setMessage("Loading...Please Wait").setView(progressBar).setCancelable(false).create();
            this.mProgressDialog = alertDialogCreate;
            alertDialogCreate.show();
        }
    }

    public void hideProgress() {
        if (isProgressVisible() && this.safeToPerformFragmentTransactions) {
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
        }
    }

    public boolean isProgressVisible() {
        AlertDialog alertDialog = this.mProgressDialog;
        return alertDialog != null && alertDialog.isShowing();
    }
}
