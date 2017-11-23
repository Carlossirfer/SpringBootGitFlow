/**
 * 
 */
package com.ciber.springBoot.HolaSpringBoot.beans;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ciber
 *
 */
@Document(collection = "properties")
public class ClaveValorMongo {
	
	@Indexed(unique=true)
	private String key;
	private String value;

	
	
	public ClaveValorMongo() {

	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ClaveValorMongo [key=" + key + ", value=" + value + "]";
	}
	
	

}
