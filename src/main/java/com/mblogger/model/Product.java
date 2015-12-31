package com.mblogger.model;

import java.util.Date;

public class Product {

	long id;
	int attribute_set_id;
	long price;
	boolean status;
	boolean visibility;
	String sku;
	String name;
	String type_id;
	Date created_at;
	Date updated_at;
	//CAttributes custom_attributes;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the attribute_set_id
	 */
	public int getAttribute_set_id() {
		return attribute_set_id;
	}

	/**
	 * @param attribute_set_id
	 *            the attribute_set_id to set
	 */
	public void setAttribute_set_id(int attribute_set_id) {
		this.attribute_set_id = attribute_set_id;
	}

	/**
	 * @return the price
	 */
	public long getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the visibility
	 */
	public boolean isVisibility() {
		return visibility;
	}

	/**
	 * @param visibility
	 *            the visibility to set
	 */
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku
	 *            the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type_id
	 */
	public String getType_id() {
		return type_id;
	}

	/**
	 * @param type_id
	 *            the type_id to set
	 */
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	/**
	 * @return the created_at
	 */
	public Date getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at
	 *            the created_at to set
	 */
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return the updated_at
	 */
	public Date getUpdated_at() {
		return updated_at;
	}

	/**
	 * @param updated_at
	 *            the updated_at to set
	 */
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	/**
	 * @return the custom_attributes
	 *//*
	public CAttributes getCustom_attributes() {
		return custom_attributes;
	}

	*//**
	 * @param custom_attributes
	 *            the custom_attributes to set
	 *//*
	public void setCustom_attributes(CAttributes custom_attributes) {
		this.custom_attributes = custom_attributes;
	}*/

}
