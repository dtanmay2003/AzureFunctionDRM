package com.be.axa.drm.convention;

public class ConventionModel {

    private String convention_id;
    private String process_manager_identifier;
    private String segment_type;
    private String created_by;
    private String created_date;
    private String modified_date;
    private String valid_from;
    private String valid_to;

    public String getConvention_id() {
        return convention_id;
    }

    public void setConvention_id(String convention_id) {
        this.convention_id = convention_id;
    }

    public String getProcess_manager_identifier() {
        return process_manager_identifier;
    }

    public void setProcess_manager_identifier(String process_manager_identifier) {
        this.process_manager_identifier = process_manager_identifier;
    }

    public String getSegment_type() {
        return segment_type;
    }

    public void setSegment_type(String segment_type) {
        this.segment_type = segment_type;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getModified_date() {
        return modified_date;
    }

    public void setModified_date(String modified_date) {
        this.modified_date = modified_date;
    }

    public String getValid_from() {
        return valid_from;
    }

    public void setValid_from(String valid_from) {
        this.valid_from = valid_from;
    }

    public String getValid_to() {
        return valid_to;
    }

    public void setValid_to(String valid_to) {
        this.valid_to = valid_to;
    }

    
}