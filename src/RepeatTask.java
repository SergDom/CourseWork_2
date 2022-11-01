public enum RepeatTask {
    SINGLE ("однократная"),
    DAILY ("ежедневная"),
    WEAKLY ("еженедельная"),
    MONTHLY ("ежемесячная"),
    ANNUAL ("ежегодная");

    private final String name;

    RepeatTask (String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}



//    Repeatability x = null;
//        if (repeatability == 1) {
//                x = Repeatability.single;
//                } else if (repeatability == 2) {
//                x = Repeatability.daily;
//                } else if (repeatability == 3) {
//                x = Repeatability.weekly;
//                } else if (repeatability == 4) {
//                x = Repeatability.monthly;
//                } else if (repeatability == 5) {
//                x = Repeatability.annual;
//                }
//                return x;