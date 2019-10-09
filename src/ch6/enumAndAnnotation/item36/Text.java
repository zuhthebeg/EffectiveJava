package ch6.enumAndAnnotation.item36;

import java.util.*;

// 코드 36-2 EnumSet - 비트 필드를 대체하는 현대적 기법 (224쪽)
public class Text {

    /*** AntiPattern */
    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 1;
    public static final int STYLE_UNDERLINE = 1 << 2;
    public static final int STYLE_STRIKETHROUGH = 1 << 3;
    /***/

    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // 어떤 Set을 넘겨도 되나, EnumSet이 가장 좋다.
    public void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles %s to text%n",
                Objects.requireNonNull(styles));
    }
    // 사용 예
    public static void main(String[] args) {
        System.out.println("STYLE_BOLD | STYLE_UNDERLINE : " + (STYLE_BOLD | STYLE_UNDERLINE));

        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}