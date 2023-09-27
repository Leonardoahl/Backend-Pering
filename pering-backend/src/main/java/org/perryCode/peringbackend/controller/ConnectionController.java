package org.perryCode.peringbackend.controller;

import java.util.List;

import org.perryCode.peringbackend.entity.Connection;
import org.perryCode.peringbackend.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conntections")
public class ConnectionController {
	
	@Autowired
	ConnectionService connectionService;

	@GetMapping
	public List<Connection> getAllConnections(){
		return connectionService.getAllConnections();
	}
	
	@GetMapping("{id}")
	public Connection getConnectionById(@PathVariable Long id) {
		return connectionService.getConnectionById(id);
	}
	
	@PostMapping
	public Connection createConnection(@RequestBody Connection connection) {
		return connectionService.createConnection(connection);
	}
	
	
	
}
