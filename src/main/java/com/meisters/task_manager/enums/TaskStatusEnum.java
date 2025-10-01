package com.meisters.task_manager.enums;

public enum TaskStatusEnum {
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String formattedName;

    TaskStatusEnum(String formattedName) {
        this.formattedName = formattedName;
    }

    public String getFormattedName()
    {
        return formattedName;
    }
}
