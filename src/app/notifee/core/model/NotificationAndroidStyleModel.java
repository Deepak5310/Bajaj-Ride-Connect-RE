package app.notifee.core.model;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.HtmlCompat;
import app.notifee.core.Logger;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import n.o.t.i.f.e.e.l;
import n.o.t.i.f.e.e.n;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationAndroidStyleModel {
    private static final String TAG = "NotificationAndroidStyle";
    private Bundle mNotificationAndroidStyleBundle;

    private NotificationAndroidStyleModel(Bundle bundle) {
        this.mNotificationAndroidStyleBundle = bundle;
    }

    public static NotificationAndroidStyleModel fromBundle(Bundle bundle) {
        return new NotificationAndroidStyleModel(bundle);
    }

    private Task<NotificationCompat.Style> getBigPictureStyleTask(Executor executor) {
        return Tasks.call(executor, new Callable() { // from class: app.notifee.core.model.NotificationAndroidStyleModel$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m508xb4e8acab();
            }
        });
    }

    private NotificationCompat.BigTextStyle getBigTextStyle() {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        if (this.mNotificationAndroidStyleBundle.containsKey("text")) {
            bigTextStyle = bigTextStyle.bigText(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("text"), 0));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("title")) {
            bigTextStyle = bigTextStyle.setBigContentTitle(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("title"), 0));
        }
        return this.mNotificationAndroidStyleBundle.containsKey("summary") ? bigTextStyle.setSummaryText(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("summary"), 0)) : bigTextStyle;
    }

    private NotificationCompat.InboxStyle getInboxStyle() {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        if (this.mNotificationAndroidStyleBundle.containsKey("title")) {
            inboxStyle = inboxStyle.setBigContentTitle(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("title"), 0));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("summary")) {
            inboxStyle = inboxStyle.setSummaryText(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("summary"), 0));
        }
        ArrayList<String> stringArrayList = this.mNotificationAndroidStyleBundle.getStringArrayList("lines");
        for (int i = 0; i < ((ArrayList) Objects.requireNonNull(stringArrayList)).size(); i++) {
            inboxStyle = inboxStyle.addLine(HtmlCompat.fromHtml(stringArrayList.get(i), 0));
        }
        return inboxStyle;
    }

    private Task<NotificationCompat.Style> getMessagingStyleTask(final Executor executor) {
        return Tasks.call(executor, new Callable() { // from class: app.notifee.core.model.NotificationAndroidStyleModel$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m509x25b4cf9e(executor);
            }
        });
    }

    private static Task<Person> getPerson(Executor executor, final Bundle bundle) {
        return Tasks.call(executor, new Callable() { // from class: app.notifee.core.model.NotificationAndroidStyleModel$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NotificationAndroidStyleModel.lambda$getPerson$0(bundle);
            }
        });
    }

    static /* synthetic */ Person lambda$getPerson$0(Bundle bundle) throws Exception {
        Bitmap bitmap;
        Person.Builder builder = new Person.Builder();
        builder.setName(bundle.getString("name"));
        if (bundle.containsKey("id")) {
            builder.setKey(bundle.getString("id"));
        }
        if (bundle.containsKey("bot")) {
            builder.setBot(bundle.getBoolean("bot"));
        }
        if (bundle.containsKey("important")) {
            builder.setImportant(bundle.getBoolean("important"));
        }
        if (bundle.containsKey("icon")) {
            String str = (String) Objects.requireNonNull(bundle.getString("icon"));
            try {
                bitmap = (Bitmap) Tasks.await(n.a(str), 10L, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                Logger.e(TAG, "Timeout occurred whilst trying to retrieve a person icon: " + str, (Exception) e);
                bitmap = null;
            } catch (Exception e2) {
                Logger.e(TAG, "An error occurred whilst trying to retrieve a person icon: " + str, e2);
                bitmap = null;
            }
            if (bitmap != null) {
                builder.setIcon(IconCompat.createWithAdaptiveBitmap(bitmap));
            }
        }
        if (bundle.containsKey(ReactNativeBlobUtilConst.DATA_ENCODE_URI)) {
            builder.setUri(bundle.getString(ReactNativeBlobUtilConst.DATA_ENCODE_URI));
        }
        return builder.build();
    }

    public Task<NotificationCompat.Style> getStyleTask(Executor executor) {
        int iA = l.a(this.mNotificationAndroidStyleBundle.get("type"));
        if (iA == 0) {
            return getBigPictureStyleTask(executor);
        }
        if (iA == 1) {
            return Tasks.forResult(getBigTextStyle());
        }
        if (iA == 2) {
            return Tasks.forResult(getInboxStyle());
        }
        if (iA != 3) {
            return null;
        }
        return getMessagingStyleTask(executor);
    }

    /* JADX INFO: renamed from: lambda$getBigPictureStyleTask$1$app-notifee-core-model-NotificationAndroidStyleModel, reason: not valid java name */
    NotificationCompat.Style m508xb4e8acab() throws Exception {
        String string;
        Bitmap bitmap;
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        Bitmap bitmap2 = null;
        if (this.mNotificationAndroidStyleBundle.containsKey("picture")) {
            String str = (String) Objects.requireNonNull(this.mNotificationAndroidStyleBundle.getString("picture"));
            try {
                bitmap = (Bitmap) Tasks.await(n.a(str), 10L, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                Logger.e(TAG, "Timeout occurred whilst trying to retrieve a big picture style image: " + str, (Exception) e);
                bitmap = null;
            } catch (Exception e2) {
                Logger.e(TAG, "An error occurred whilst trying to retrieve a big picture style image: " + str, e2);
                bitmap = null;
            }
            if (bitmap != null) {
                bigPictureStyle.bigPicture(bitmap);
            }
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("largeIcon")) {
            string = this.mNotificationAndroidStyleBundle.getString("largeIcon");
            if (string == null) {
                bigPictureStyle.bigLargeIcon((Bitmap) null);
            }
        } else {
            string = null;
        }
        if (string != null) {
            try {
                bitmap2 = (Bitmap) Tasks.await(n.a(string), 10L, TimeUnit.SECONDS);
            } catch (TimeoutException e3) {
                Logger.e(TAG, "Timeout occurred whilst trying to retrieve a big picture style large icon: " + string, (Exception) e3);
            } catch (Exception e4) {
                Logger.e(TAG, "An error occurred whilst trying to retrieve a big picture style large icon: " + string, e4);
            }
            if (bitmap2 != null) {
                bigPictureStyle.bigLargeIcon(bitmap2);
            }
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("title")) {
            bigPictureStyle = bigPictureStyle.setBigContentTitle(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("title"), 0));
        }
        return this.mNotificationAndroidStyleBundle.containsKey("summary") ? bigPictureStyle.setSummaryText(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("summary"), 0)) : bigPictureStyle;
    }

    /* JADX INFO: renamed from: lambda$getMessagingStyleTask$2$app-notifee-core-model-NotificationAndroidStyleModel, reason: not valid java name */
    NotificationCompat.Style m509x25b4cf9e(Executor executor) throws Exception {
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle((Person) Tasks.await(getPerson(executor, (Bundle) Objects.requireNonNull(this.mNotificationAndroidStyleBundle.getBundle("person"))), 20L, TimeUnit.SECONDS));
        if (this.mNotificationAndroidStyleBundle.containsKey("title")) {
            messagingStyle = messagingStyle.setConversationTitle(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("title"), 0));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("group")) {
            messagingStyle = messagingStyle.setGroupConversation(this.mNotificationAndroidStyleBundle.getBoolean("group"));
        }
        ArrayList parcelableArrayList = this.mNotificationAndroidStyleBundle.getParcelableArrayList("messages");
        for (int i = 0; i < ((ArrayList) Objects.requireNonNull(parcelableArrayList)).size(); i++) {
            Bundle bundle = (Bundle) parcelableArrayList.get(i);
            messagingStyle = messagingStyle.addMessage(HtmlCompat.fromHtml(bundle.getString("text"), 0), l.b(bundle.get("timestamp")), bundle.containsKey("person") ? (Person) Tasks.await(getPerson(executor, (Bundle) Objects.requireNonNull(bundle.getBundle("person"))), 20L, TimeUnit.SECONDS) : null);
        }
        return messagingStyle;
    }

    public Bundle toBundle() {
        return (Bundle) this.mNotificationAndroidStyleBundle.clone();
    }
}
