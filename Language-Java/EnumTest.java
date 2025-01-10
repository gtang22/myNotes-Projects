public enum EnumTest {
    SUNDAY("off"),
    MONDAY("working"),
    TUESDAY("working"),
    WEDNESDAY("working"),
    THURSDAY("working"),
    FRIDAY("working"),
    SATURDAY("off");

    private String typeOfDay;

    EnumTest(String typeOfDay) {
        this.typeOfDay = typeOfDay;
    }

    public static void main(String[] args) {
        for (EnumTest et : EnumTest.values()) {
            System.out.println(et.name() + " : " + et.typeOfDay);
        }
    }
}
