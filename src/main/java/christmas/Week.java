package christmas;

public enum Week {
    THU("목"),
    FRI("금"),
    SAT("토"),
    SUN("일"),
    MON("월"),
    TUE("화"),
    WED("수");

    String kor;

    Week(String kor){
        this.kor = kor;
    }

    boolean checkWeekend(){
        if(kor.equals("금") || kor.equals("토")){
            return true;
        }
        return false;
    }
}
