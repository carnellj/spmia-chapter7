package com.thoughtmechanix.licenses.events.models;

public class OrganizationChangeModel{
    private String type;
    private String action;
    private String organizationId;

    public OrganizationChangeModel(){
        super();
    }

    public  OrganizationChangeModel(String type, String action, String organizationId) {
        super();
        this.type   = type;
        this.action = action;
        this.organizationId = organizationId;
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

    @Override
    public String toString() {
        return "OrganizationChangeModel [type=" + type +
                ", action=" + action +
                ", orgId="  + organizationId +"]";
    }
}
