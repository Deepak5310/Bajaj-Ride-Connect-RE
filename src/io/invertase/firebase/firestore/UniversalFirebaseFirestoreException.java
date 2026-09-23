package io.invertase.firebase.firestore;

import androidx.core.os.EnvironmentCompat;
import com.google.common.base.Ascii;
import com.google.firebase.firestore.FirebaseFirestoreException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class UniversalFirebaseFirestoreException extends Exception {
    private final String code;
    private final String message;

    /* JADX WARN: Code duplicated, block: B:134:0x022d  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    UniversalFirebaseFirestoreException(FirebaseFirestoreException firebaseFirestoreException, Throwable th) {
        String str;
        String str2;
        String str3;
        String str4;
        String message;
        String str5;
        super(firebaseFirestoreException != null ? firebaseFirestoreException.getMessage() : "", th);
        if (th == null || th.getMessage() == null) {
            str = "permission-denied";
        } else {
            str = "permission-denied";
            if (th.getMessage().contains(":")) {
                Matcher matcher = Pattern.compile("([A-Z_]{3,25}):\\s(.*)").matcher(th.getMessage());
                if (matcher.find()) {
                    String strTrim = matcher.group(1).trim();
                    str2 = "Operation was attempted past the valid range.";
                    String strTrim2 = matcher.group(2).trim();
                    strTrim.hashCode();
                    byte b = -1;
                    switch (strTrim.hashCode()) {
                        case -1842427240:
                            if (strTrim.equals("DATA_LOSS")) {
                                b = 0;
                            }
                            break;
                        case -1711692763:
                            if (strTrim.equals("INVALID_ARGUMENT")) {
                                b = 1;
                            }
                            break;
                        case -1416305653:
                            if (strTrim.equals("PERMISSION_DENIED")) {
                                b = 2;
                            }
                            break;
                        case -1031784143:
                            if (strTrim.equals("CANCELLED")) {
                                b = 3;
                            }
                            break;
                        case -1025686472:
                            if (strTrim.equals("RESOURCE_EXHAUSTED")) {
                                b = 4;
                            }
                            break;
                        case -849706474:
                            if (strTrim.equals("UNAUTHENTICATED")) {
                                b = 5;
                            }
                            break;
                        case -476794961:
                            if (strTrim.equals("ABORTED")) {
                                b = 6;
                            }
                            break;
                        case -376214182:
                            if (strTrim.equals("DEADLINE_EXCEEDED")) {
                                b = 7;
                            }
                            break;
                        case 433141802:
                            if (strTrim.equals("UNKNOWN")) {
                                b = 8;
                            }
                            break;
                        case 695165606:
                            if (strTrim.equals("OUT_OF_RANGE")) {
                                b = 9;
                            }
                            break;
                        case 979228314:
                            if (strTrim.equals("FAILED_PRECONDITION")) {
                                b = 10;
                            }
                            break;
                        case 1023286998:
                            if (strTrim.equals("NOT_FOUND")) {
                                b = Ascii.VT;
                            }
                            break;
                        case 1353037501:
                            if (strTrim.equals("INTERNAL")) {
                                b = Ascii.FF;
                            }
                            break;
                        case 1487498288:
                            if (strTrim.equals("UNAVAILABLE")) {
                                b = Ascii.CR;
                            }
                            break;
                        case 1661336131:
                            if (strTrim.equals("ALREADY_EXISTS")) {
                                b = Ascii.SO;
                            }
                            break;
                        case 1854913705:
                            if (strTrim.equals("UNIMPLEMENTED")) {
                                b = Ascii.SI;
                            }
                            break;
                    }
                    switch (b) {
                        case 0:
                            str4 = "Unrecoverable data loss or corruption.";
                            str3 = "data-loss";
                            break;
                        case 1:
                            str4 = "Client specified an invalid argument. Note that this differs from failed-precondition. invalid-argument indicates arguments that are problematic regardless of the state of the system (e.g., an invalid field name).";
                            str3 = "invalid-argument";
                            break;
                        case 2:
                            str4 = "The caller does not have permission to execute the specified operation.";
                            str3 = str;
                            break;
                        case 3:
                            str4 = "The operation was cancelled (typically by the caller).";
                            str3 = "cancelled";
                            break;
                        case 4:
                            str3 = "resource-exhausted";
                            str4 = "Some resource has been exhausted, perhaps a per-user quota, or perhaps the entire file system is out of space.";
                            break;
                        case 5:
                            str3 = "unauthenticated";
                            str4 = "The request does not have valid authentication credentials for the operation.";
                            break;
                        case 6:
                            str4 = "The operation was aborted, typically due to a concurrency issue like transaction aborts, etc.";
                            str3 = "aborted";
                            break;
                        case 7:
                            str4 = "Deadline expired before operation could complete. For operations that change the state of the system, this error may be returned even if the operation has completed successfully. For example, a successful response from a server could have been delayed long enough for the deadline to expire.";
                            str3 = "deadline-exceeded";
                            break;
                        case 8:
                            str4 = "Unknown error or an error from a different error domain.";
                            str3 = EnvironmentCompat.MEDIA_UNKNOWN;
                            break;
                        case 9:
                            str3 = "out-of-range";
                            str4 = str2;
                            break;
                        case 10:
                            str4 = strTrim2.contains("query requires an index") ? strTrim2 : "Operation was rejected because the system is not in a state required for the operation's execution. Ensure your query has been indexed via the Firebase console.";
                            str3 = "failed-precondition";
                            break;
                        case 11:
                            str4 = "Some requested document was not found.";
                            str3 = "not-found";
                            break;
                        case 12:
                            str4 = "Internal errors. Means some invariants expected by underlying system has been broken. If you see one of these errors, something is very broken.";
                            str3 = "internal";
                            break;
                        case 13:
                            str3 = "unavailable";
                            str4 = "The service is currently unavailable. This is a most likely a transient condition and may be corrected by retrying with a backoff.";
                            break;
                        case 14:
                            str4 = "Some document that we attempted to create already exists.";
                            str3 = "already-exists";
                            break;
                        case 15:
                            str3 = "unimplemented";
                            str4 = "Operation is not implemented or not supported/enabled.";
                            break;
                    }
                }
                str3 = null;
                str4 = "An unknown error occurred";
            }
            if (str3 != null && firebaseFirestoreException != null) {
                switch (AnonymousClass1.$SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[firebaseFirestoreException.getCode().ordinal()]) {
                    case 1:
                        message = "The operation was aborted, typically due to a concurrency issue like transaction aborts, etc.";
                        str5 = "aborted";
                        break;
                    case 2:
                        message = "Some document that we attempted to create already exists.";
                        str5 = "already-exists";
                        break;
                    case 3:
                        message = "The operation was cancelled (typically by the caller).";
                        str5 = "cancelled";
                        break;
                    case 4:
                        message = "Unrecoverable data loss or corruption.";
                        str5 = "data-loss";
                        break;
                    case 5:
                        message = "Deadline expired before operation could complete. For operations that change the state of the system, this error may be returned even if the operation has completed successfully. For example, a successful response from a server could have been delayed long enough for the deadline to expire.";
                        str5 = "deadline-exceeded";
                        break;
                    case 6:
                        if (firebaseFirestoreException.getMessage() != null && firebaseFirestoreException.getMessage().contains("query requires an index")) {
                            message = firebaseFirestoreException.getMessage();
                        } else {
                            message = "Operation was rejected because the system is not in a state required for the operation's execution. Ensure your query has been indexed via the Firebase console.";
                        }
                        str5 = "failed-precondition";
                        break;
                    case 7:
                        message = "Internal errors. Means some invariants expected by underlying system has been broken. If you see one of these errors, something is very broken.";
                        str5 = "internal";
                        break;
                    case 8:
                        message = "Client specified an invalid argument. Note that this differs from failed-precondition. invalid-argument indicates arguments that are problematic regardless of the state of the system (e.g., an invalid field name).";
                        str5 = "invalid-argument";
                        break;
                    case 9:
                        message = "Some requested document was not found.";
                        str5 = "not-found";
                        break;
                    case 10:
                        str5 = "out-of-range";
                        message = str2;
                        break;
                    case 11:
                        message = "The caller does not have permission to execute the specified operation.";
                        str5 = str;
                        break;
                    case 12:
                        str5 = "resource-exhausted";
                        message = "Some resource has been exhausted, perhaps a per-user quota, or perhaps the entire file system is out of space.";
                        break;
                    case 13:
                        str5 = "unauthenticated";
                        message = "The request does not have valid authentication credentials for the operation.";
                        break;
                    case 14:
                        str5 = "unavailable";
                        message = "The service is currently unavailable. This is a most likely a transient condition and may be corrected by retrying with a backoff.";
                        break;
                    case 15:
                        str5 = "unimplemented";
                        message = "Operation is not implemented or not supported/enabled.";
                        break;
                    case 16:
                        message = "Unknown error or an error from a different error domain.";
                        str5 = EnvironmentCompat.MEDIA_UNKNOWN;
                        break;
                    default:
                        message = "An unknown error occurred";
                        str5 = EnvironmentCompat.MEDIA_UNKNOWN;
                        break;
                }
            } else {
                message = str4;
                str5 = str3;
            }
            this.code = str5;
            this.message = message;
        }
        str2 = "Operation was attempted past the valid range.";
        str3 = null;
        str4 = "An unknown error occurred";
        if (str3 != null) {
            message = str4;
            str5 = str3;
        } else {
            message = str4;
            str5 = str3;
        }
        this.code = str5;
        this.message = message;
    }

    /* JADX INFO: renamed from: io.invertase.firebase.firestore.UniversalFirebaseFirestoreException$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code;

        static {
            int[] iArr = new int[FirebaseFirestoreException.Code.values().length];
            $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code = iArr;
            try {
                iArr[FirebaseFirestoreException.Code.ABORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.ALREADY_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.DATA_LOSS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.DEADLINE_EXCEEDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.FAILED_PRECONDITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.INTERNAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.INVALID_ARGUMENT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.NOT_FOUND.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.OUT_OF_RANGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.PERMISSION_DENIED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.RESOURCE_EXHAUSTED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNAUTHENTICATED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNAVAILABLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNIMPLEMENTED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public String getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
