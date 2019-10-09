package ch6.enumAndAnnotation.item34;

import ch6.enumAndAnnotation.AntiPattern;

@AntiPattern
public enum  PayrollDayOld {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8*60;

    int pay(int minutesWorked, int payRate) {
        int basePay = minutesWorked*payRate;
        int overtimePay;
        switch(this) {
            case SATURDAY: case SUNDAY: // 주말
                overtimePay = basePay / 2;
            break;
            default: // 주중
                overtimePay = minutesWorked <= MINS_PER_SHIFT ?
                        0: (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        }
        return basePay + overtimePay;
    }

}
