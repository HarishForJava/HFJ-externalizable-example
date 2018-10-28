package com.hfj.externalizable.model;

import javax.persistence.*;
/**
 * @author HFJ
 *
 */
@Entity
@Table
public class SerializedEnjoyer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private byte[] serializedObj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getSerializedObj() {
		return serializedObj;
	}

	public void setSerializedObj(byte[] serializedObj) {
		this.serializedObj = serializedObj;
	}

	public SerializedEnjoyer(byte[] serializedObj) {
		super();
		this.serializedObj = serializedObj;
	}

	public SerializedEnjoyer() {
		super();
	}

}
