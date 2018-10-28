package com.hfj.externalizable.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author HFJ
 *
 */
public class Enjoyer implements Externalizable {

	private String yourName;
	private Long mobileNumber;
	private String yourGirlFriendName;
	private Long yourGirlFriendMobileNumber;

	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getYourGirlFriendName() {
		return yourGirlFriendName;
	}

	public void setYourGirlFriendName(String yourGirlFriendName) {
		this.yourGirlFriendName = yourGirlFriendName;
	}

	public Long getYourGirlFriendMobileNumber() {
		return yourGirlFriendMobileNumber;
	}

	public void setYourGirlFriendMobileNumber(Long yourGirlFriendMobileNumber) {
		this.yourGirlFriendMobileNumber = yourGirlFriendMobileNumber;
	}

	public Enjoyer(String yourName, Long mobileNumber, String yourGirlFriendName, Long yourGirlFriendMobileNumber) {
		super();
		this.yourName = yourName;
		this.mobileNumber = mobileNumber;
		this.yourGirlFriendName = yourGirlFriendName;
		this.yourGirlFriendMobileNumber = yourGirlFriendMobileNumber;
	}

	public Enjoyer() {
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(yourName);
		out.writeLong(mobileNumber);
		out.writeUTF(yourGirlFriendName);
		/*
		 * We are not storing the field GF value.
		 */
	}
	/*
	 * Only thing you need to remember is – The readExternal() method must read
	 * the values in the same sequence and with the same types as were written
	 * by writeExternal().
	 */

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		yourName = in.readUTF();
		mobileNumber = in.readLong();
		yourGirlFriendName = in.readUTF();
	}

}
