public enum RepeatTask {
    SINGLE ("Однократная"),
    DAILY ("Ежедневная"),
    WEEKLY ("Еженедельная"),
    MONTHLY ("Ежемесячная"),
    ANNUAL ("Ежегодная");

    private final String name;

    RepeatTask (String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
