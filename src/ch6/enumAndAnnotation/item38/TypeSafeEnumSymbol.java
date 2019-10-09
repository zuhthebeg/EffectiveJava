package ch6.enumAndAnnotation.item38;

import ch6.enumAndAnnotation.AntiPattern;

@AntiPattern
public class TypeSafeEnumSymbol {

    private final String symbol;

    private TypeSafeEnumSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return symbol;
    }

    public static final TypeSafeEnumSymbol Plus = new TypeSafeEnumSymbol("+");
    public static final TypeSafeEnumSymbol Minus = new TypeSafeEnumSymbol("-");
}
