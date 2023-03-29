package com.evy.enums;

public enum MainSideBarType {
        TASKS("Tasks"),
        TICKETS("Tickets"),
        DISCUSSIONS("Discussions");

        private final String name;

        private MainSideBarType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }




}
