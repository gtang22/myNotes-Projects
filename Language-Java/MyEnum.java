public class MyEnum {
    enum Days {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}; 

    public static void main(String[] args){

        for(Days day: Days.values()){
            System.out.println(day.name() + " : " + day.ordinal());
        }
        double d = 13.5;
        int i = (int) (d * 4);
        System.out.println(i);
    }
}