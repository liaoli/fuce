package livestartv.livestar.com.fu;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Administrator on 2017/10/20 0020.
 */

public class RxBus {
    private static volatile RxBus defaultInstance = new RxBus();

    private final Subject<Object, Object> bus;

    public static RxBus getInstance(){
        return defaultInstance;
    }

    public RxBus() {
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    // 发送一个新的事件
    public void post (Object o) {
        bus.onNext(o);
    }
    // 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
    public <T> Observable<T> toObservable (Class<T> eventType) {
        return bus.ofType(eventType);
    }

}
