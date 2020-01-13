package ch10.Exception.item69;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Code69_1 {
    enum Mountain {
        STEP1, STEP2, STEP3, STEP4, STEP5;
        void climb() {
            System.out.println(this.toString() + " climb!!");

            //if(this.equals(STEP4)) // TODO: 1-1. 만약 동일 예외를 발생시킨다면?
            //    throw new ArrayIndexOutOfBoundsException();
        }
    }
    public static void main(String[] args) {
        Mountain[] range = Mountain.values();
        // TODO : 1. 비정상적인 방법 (경계검사를 줄여서 성능을 높여보자!)

        try {   // 2) try catch문 안에서는 JVM의 최적화가 제한됨
            int i=0;
            while(true) {
                range[i++].climb();
            }
        } catch (ArrayIndexOutOfBoundsException e) { // 1) 예외는 예외에 사용해야함
            // 예외로 프로그램을 종료시킴
            System.out.println("i'm on top!!!!!!!!");
        }

        // TODO : 2. 정상적인 방법
        for (Mountain m : range) { // 3) 배열순회시 JVM이 적절히 중복검사에 대한 최적화를 진행함
            m.climb();
        }
        System.out.println("i'm on top!!!!!!!!");


        // TODO : 3. 정상적인 방법 (Iterator 사용)
        for (Iterator<Mountain> m = Arrays.stream(Mountain.values()).iterator(); m.hasNext();) { // 상태 검사 메서드 hasNext()
            Mountain mm = m.next(); // 상태의존적 메서드 next()
            mm.climb();
        }
        System.out.println("i'm on top!!!!!!!!");


        // TODO : 3-1. 비정상적인 방법 Iterator에 상태검사 메서드(hasNext)가 없다면 ?
        try {
            Iterator<Mountain> m = Arrays.stream(Mountain.values()).iterator();
            while(true) { // 1과 유사하다
                Mountain mm = m.next();
                mm.climb();
            }
        } catch (NoSuchElementException e) {
            System.out.println("i'm on top!!!!!!!!");
        }

        //TODO : 4. Optional 반환
        Arrays.stream(Mountain.values()).map(Code69_1::getAsOptional).forEach(t -> t.ifPresent(Mountain::climb));
        System.out.println("i'm on top!!!!!!!!");
    }

    public static <T> Optional<T> getAsOptional(T obj) {
        try {
            return Optional.of(obj);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

}
