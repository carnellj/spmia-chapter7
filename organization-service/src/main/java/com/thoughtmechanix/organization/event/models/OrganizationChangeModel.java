package com.thoughtmechanix.organization.event.models;

public class OrganizationChangeModel{
    private String type;
    private String action;
    private String organizationId;
    private String dateTimeChange;


    public  OrganizationChangeModel(String type, String action, String organizationId, String dateTimeChange) {
        super();
        this.type   = type;
        this.action = action;
        this.organizationId = organizationId;
        this.dateTimeChange = dateTimeChange;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getDateTimeChange() {
        return dateTimeChange;
    }

    public void setDateTimeChange(String dateTimeChange) {
        this.dateTimeChange = dateTimeChange;
    }
}