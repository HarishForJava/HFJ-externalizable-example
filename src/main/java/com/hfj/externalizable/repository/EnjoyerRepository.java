package com.hfj.externalizable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hfj.externalizable.model.SerializedEnjoyer;
/**
 * @author HFJ
 *
 */
public interface EnjoyerRepository extends JpaRepository<SerializedEnjoyer, Integer> {
}
