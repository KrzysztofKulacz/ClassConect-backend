package com.example.classconectbackend.team;

public enum Subject {

    MATH("Math"), PHYSICS("Physics"), PROGRAMING("Programing"),
    ALGORITHMS_AND_DATA_STRUCTURES("AiSD"), NETWORK_SECURITY("Network security"),
    MACHINE_LEARNING("Machine learning"), OTHER("Other ");

    private final String description;

    Subject(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
