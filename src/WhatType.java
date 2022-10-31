public enum WhatType {
    PERSONAL ("личная"),
    WORK ("рабочая");

    public String name;

    WhatType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
