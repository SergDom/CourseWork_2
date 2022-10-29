public enum WhatType {
    P ("личная"),
    W ("рабочая");

    public String type;

    WhatType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
