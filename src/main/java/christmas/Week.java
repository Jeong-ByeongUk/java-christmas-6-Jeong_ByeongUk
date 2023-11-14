package christmas;

public enum Week {
    THU("목", "평일"),
    FRI("금", "주말"),
    SAT("토", "주말"),
    SUN("일", "평일"),
    MON("월", "평일"),
    TUE("화", "평일"),
    WED("수", "평일");

    private String kor;
    private String weekly;

    Week(String kor, String weekly){
        this.kor = kor;
        this.weekly = weekly;
    }

    String getKor(){
        return kor;
    }

    String getWeekly(){
        return weekly;
    }

    Week checkWeek(int date){
        Week[] weeks = Week.values();
        Week dateOfWeek = weeks[date % weeks.length];

        return dateOfWeek;
    }
}
