package com.hfj.externalizable.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hfj.externalizable.model.Enjoyer;
import com.hfj.externalizable.service.EnjoyerService;
/**
 * @author HFJ
 *
 */
@RestController
@RequestMapping("/rest")
public class EnjoyerRestController {

	@Autowired
	private EnjoyerService serializedService;

	@PostMapping("/serialize")
	public String post(@RequestBody final Enjoyer user) {
		serializedService.persist(user);
		return user.getYourName()+"  your data saved....";
	}

	@GetMapping("/deserialize")
	public List<Enjoyer> getUsers() {
		return serializedService.getEnjoyer();
	}

}
