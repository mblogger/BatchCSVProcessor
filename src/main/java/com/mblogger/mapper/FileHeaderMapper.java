package com.mblogger.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.mblogger.model.Product;

public class FileHeaderMapper implements FieldSetMapper<Product> {

	public Product mapFieldSet(FieldSet fields) throws BindException {
		Product product = new Product();

		product.setId(fields.readLong(0));
		product.setAttribute_set_id(fields.readInt(1));
		product.setPrice(fields.readLong(2));
		product.setStatus(fields.readBoolean(3));
		product.setVisibility(fields.readBoolean(4));
		product.setSku(fields.readString(5));
		product.setName(fields.readString(6));
		product.setType_id(fields.readString(7));
		product.setCreated_at(fields.readDate(8));
		product.setUpdated_at(fields.readDate(9));

		return product;
	}

}
