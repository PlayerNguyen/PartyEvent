package com.playernguyen.partyevent.config;

public enum  ConfigKey {

    NAME ("name", false),
    TIMELINE ("timeline", false),
    PREPARE_DURATION ("prepare", false),
    OCCUR_DURATION  ("occur", false),

    ON_JOIN("handle_block.join", false),
    ON_LEAVE("handle_block.leave", false),


    ;

    private String path;
    private boolean nullable;

    ConfigKey(String path, boolean nullable) {
        this.path = path;
        this.nullable = nullable;
    }

    public String getPath() {
        return path;
    }

    public boolean isNullable() {
        return nullable;
    }
}
