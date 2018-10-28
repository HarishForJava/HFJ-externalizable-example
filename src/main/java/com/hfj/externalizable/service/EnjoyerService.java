package com.hfj.externalizable.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfj.externalizable.model.Enjoyer;
import com.hfj.externalizable.model.SerializedEnjoyer;
import com.hfj.externalizable.repository.EnjoyerRepository;
/**
 * @author HFJ
 *
 */
@Service
public class EnjoyerService {

	@Autowired
	private EnjoyerRepository enjoyerRepository;

	public void persist(Enjoyer enjoyer) {
		byte[] serializedObj = objToserializedBytes(enjoyer);
		SerializedEnjoyer serializedUser = new SerializedEnjoyer(serializedObj);
		enjoyerRepository.save(serializedUser);
	}

	public List<Enjoyer> getEnjoyer() {
		return enjoyerRepository.findAll().stream().map(serializedObj -> fromStringToObj(serializedObj.getSerializedObj()))
				.collect(Collectors.toList());
	}

	private static byte[] objToserializedBytes(Serializable o) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(o);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray();
	}

	private static Enjoyer fromStringToObj(byte[] data) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
			Object obj = ois.readObject();
			ois.close();
			return (Enjoyer) obj;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
