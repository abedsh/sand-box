package com.codefish.sandbox;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


        String result="";

    @Test
    public void returnAValue() {
        result = "";
        Observable<String> observer = Observable.just("Hello"); // provides datea
        observer.subscribe(s -> result = s); // Callable as subscriber
        assertTrue(result.equals("Hello"));
    }
}



//
//package com.vogella.android.rxjava.simple;
//
//        import org.junit.Test;
//
//        import io.reactivex.Observable;
//
//        import static junit.framework.Assert.assertTrue;
//
//
//public class RxJavaUnitTest {
//    String result="";
//
//    // Simple subscription to a fix value
//    @Test
//    public void returnAValue(){
//        result = "";
//        Observable<String> observer = Observable.just("Hello"); // provides datea
//        observer.subscribe(s -> result=s); // Callable as subscriber
//        assertTrue(result.equals("Hello"));
//    }
//}