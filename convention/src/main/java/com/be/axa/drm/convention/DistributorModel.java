package com.be.axa.drm.convention;

import java.util.List;

public class DistributorModel {
	
	private String id;
	private String distributor_id;
	private String enterprise_number;
	private String organization_type;
	private String contract_type;
	private String fsma_status;
	private String axa_distributor_status;
	private String lineofbusiness;
	private List convention;
	private List process;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDistributor_id() {
		return distributor_id;
	}
	public void setDistributor_id(String distributor_id) {
		this.distributor_id = distributor_id;
	}
	public String getEnterprise_number() {
		return enterprise_number;
	}
	public void setEnterprise_number(String enterprise_number) {
		this.enterprise_number = enterprise_number;
	}
	public String getOrganization_type() {
		return organization_type;
	}
	public void setOrganization_type(String organization_type) {
		this.organization_type = organization_type;
	}
	public String getContract_type() {
		return contract_type;
	}
	public void setContract_type(String contract_type) {
		this.contract_type = contract_type;
	}
	public String getFsma_status() {
		return fsma_status;
	}
	public void setFsma_status(String fsma_status) {
		this.fsma_status = fsma_status;
	}
	public String getAxa_distributor_status() {
		return axa_distributor_status;
	}
	public void setAxa_distributor_status(String axa_distributor_status) {
		this.axa_distributor_status = axa_distributor_status;
	}
	public String getLineofbusiness() {
		return lineofbusiness;
	}
	public void setLineofbusiness(String lineofbusiness) {
		this.lineofbusiness = lineofbusiness;
	}
	public List getConvention() {
		return convention;
	}
	public void setConvention(List convention) {
		this.convention = convention;
	}
	public List getProcess() {
		return process;
	}
	public void setProcess(List process) {
		this.process = process;
	}
 

}