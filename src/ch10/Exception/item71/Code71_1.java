package ch10.Exception.item71;

import java.io.IOException;
import java.util.Optional;

public class Code71_1 {
    static class SomeObject {
        static SomeObject getInstance() {
            return new SomeObject();
        }
        static void someAction(String[] args) throws IOException {
            throw new IOException();
        }
        static void someAction2(String[] args) {
            System.out.println(args);
        }
        // TODO : 옵셔널 반환
        static <T> Optional<String[]> someAction3(String[] args) {
            return Optional.ofNullable(args);
        }

        static boolean actionPermitted(String[] args) {
            if(args.length > 0) return true;
            else return false;
        }
    }
    public static void main(String[] args) {
        try {

        } catch(Exception e) {
            throw new AssertionError();
        }

        //or

        try {

        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }



        // 71-1 검사 예외를 던지는 메서드 - 리펙터링 전
        SomeObject obj = SomeObject.getInstance();
        try {
            obj.someAction(args);
        } catch (IOException e) {

        }

        //Stream.of(new int[]{1, 2, 3, 4, 5}).forEach(SomeObject::someAction);




        // TODO : 리펙터링 후
        if(obj.actionPermitted(args)) {
            obj.someAction2(args);
        } else {
            //... 예외 상황 처리
        }
    }

}
