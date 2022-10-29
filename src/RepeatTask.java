public enum RepeatTask {
    S ("однократная"),
    D ("ежедневная"),
    W ("еженедельная"),
    M ("ежемесячная"),
    A ("ежегодная");

    private final String name;

    RepeatTask (String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
