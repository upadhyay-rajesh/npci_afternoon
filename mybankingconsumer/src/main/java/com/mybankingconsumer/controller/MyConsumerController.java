package com.mybankingconsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mybankingconsumer.dto.Employee;

@RestController
@RequestMapping("/api/v1/consumers")
public class MyConsumerController {

	@Autowired
	DiscoveryClient ds;

	@GetMapping
	public List<Employee> getAll() {

		List<ServiceInstance> ll = ds.getInstances("MYBANKING");

		ServiceInstance myinstance = ll.get(0);

		String uri = myinstance.getUri().toString();

		RestTemplate rr = new RestTemplate();

		return rr.getForObject(uri + "/api/v1/employees", List.class);
	}

	@PostMapping
	public Employee createPost(@RequestBody Employee ee) {

		List<ServiceInstance> ll = ds.getInstances("MYBANKING");

		ServiceInstance myinstance = ll.get(0);

		String uri = myinstance.getUri().toString();

		RestTemplate restTemplate = new RestTemplate();
		Employee response = restTemplate.postForObject(uri + "/api/v1/employees", ee, Employee.class);
		return response;
	}

	@PutMapping("/{id}")
	public Employee updatePost(@RequestBody Employee ee, @PathVariable String id) {

		List<ServiceInstance> ll = ds.getInstances("MYBANKING");

		ServiceInstance myinstance = ll.get(0);

		String uri = myinstance.getUri().toString();

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri + "/api/v1/employees" + id, ee);
		return ee;
	}

	@DeleteMapping("/{id}")
	public String deletePost(@PathVariable String id) {

		List<ServiceInstance> ll = ds.getInstances("MYBANKING");

		ServiceInstance myinstance = ll.get(0);

		String uri = myinstance.getUri().toString();

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri + "/api/v1/employees" + id);

		return "deleted";
	}

}
