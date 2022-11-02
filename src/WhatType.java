public enum WhatType {
    PERSONAL("Личная"),
    WORK("Рабочая");

    public final String name;

    WhatType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
