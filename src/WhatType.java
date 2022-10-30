public enum WhatType {
    P ("личная"),
    W ("рабочая");

    public String name;

    WhatType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
