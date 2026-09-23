package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import rx.Observable;
import rx.Scheduler;

/* JADX INFO: loaded from: classes5.dex */
final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;

    @Nullable
    private final Scheduler scheduler;

    RxJavaCallAdapter(Type type, @Nullable Scheduler scheduler, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.responseType = type;
        this.scheduler = scheduler;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isSingle = z4;
        this.isCompletable = z5;
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    /* JADX WARN: Code duplicated, block: B:20:0x0039  */
    /* JADX WARN: Code duplicated, block: B:22:0x003d  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // retrofit2.CallAdapter
    public Object adapt(Call<R> call) {
        Observable.OnSubscribe callExecuteOnSubscribe;
        Observable.OnSubscribe bodyOnSubscribe;
        Observable observableCreate;
        Scheduler scheduler;
        if (this.isAsync) {
            callExecuteOnSubscribe = new CallEnqueueOnSubscribe(call);
        } else {
            callExecuteOnSubscribe = new CallExecuteOnSubscribe(call);
        }
        if (this.isResult) {
            bodyOnSubscribe = new ResultOnSubscribe(callExecuteOnSubscribe);
        } else {
            if (this.isBody) {
                bodyOnSubscribe = new BodyOnSubscribe(callExecuteOnSubscribe);
            }
            observableCreate = Observable.create(callExecuteOnSubscribe);
            scheduler = this.scheduler;
            if (scheduler != null) {
                observableCreate = observableCreate.subscribeOn(scheduler);
            }
            if (this.isSingle) {
                return observableCreate.toSingle();
            }
            if (this.isCompletable) {
                return observableCreate.toCompletable();
            }
            return observableCreate;
        }
        callExecuteOnSubscribe = bodyOnSubscribe;
        observableCreate = Observable.create(callExecuteOnSubscribe);
        scheduler = this.scheduler;
        if (scheduler != null) {
            observableCreate = observableCreate.subscribeOn(scheduler);
        }
        if (this.isSingle) {
            return observableCreate.toSingle();
        }
        if (this.isCompletable) {
            return observableCreate.toCompletable();
        }
        return observableCreate;
    }
}
