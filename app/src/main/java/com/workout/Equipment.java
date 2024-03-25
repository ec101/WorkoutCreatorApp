package com.workout;

public enum Equipment {
    SPACE("Space"),
    RESISTANCE_BAND("ResistanceBand"),
    CHAIR("Chair"),
    KETTLE_BELL("KettleBell");

    private String name;

    private Equipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Equipment getEquipment(String equipment) {
        if (equipment == null) {
            return null;
        }

        for (Equipment equ : Equipment.values()) {
            if (equipment.equalsIgnoreCase(equ.getName())) {
                return equ;
            }
        }
        return null;
    }
}
