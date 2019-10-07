package ch6.enumAndAnnotation;

@AntiPattern
public interface IntEnumPattern {
    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;

    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;

    //문자열 열거 패턴 (하드코딩)
    public static final String BANANA_MORADO = "0";
    public static final String BANANA_TINDOK = "1 "; // 오타



}

