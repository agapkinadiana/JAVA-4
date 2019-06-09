import rx.*;
import rx.subjects.BehaviorSubject;

public class Main {
    public static void main(String[] args) {
        System.out.println("_________first_________");
        BehaviorSubject<Integer> a = BehaviorSubject.create();
        BehaviorSubject<Integer> b = BehaviorSubject.create();
        Observable<Integer> c = Observable.combineLatest(a,b,(i1,i2) -> i1+i2);
        c.subscribe (System.out::println);
        a.onNext(10);
        b.onNext(10);
        a.onNext(20);

        System.out.println("_________second_________");
        BehaviorSubject<Integer> x = BehaviorSubject.create();
        BehaviorSubject<Integer> y = BehaviorSubject.create();
        Observable<Integer> z = Observable.combineLatest(x,y,(i1,i2) -> i1+i2);
        Observable<Integer> cIn2 = z.map(i->i*i).filter(i->i%2 == 0);
        cIn2.subscribe (System.out::println);
        x.onNext(1);
        y.onNext(2);
        x.onNext(2);
        x.onNext(3);
        x.onNext(4);
    }
}
