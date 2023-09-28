package org.perryCode.peringbackend.service.impl;

/*
import java.util.List;
import java.util.Optional;

import org.perryCode.peringbackend.entity.Connection;
import org.perryCode.peringbackend.repository.ConnectionRepository;
import org.perryCode.peringbackend.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionServiceImpl  implements ConnectionService{

	@Autowired
	ConnectionRepository connectionRepository; 
	
	
	@Override
	public List<Connection> getAllConnections() {
		return (List<Connection>) connectionRepository.findAll();
	}

	@Override
	public Connection getConnectionById(Long id) {
		return connectionRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Connection does not exist with id:  "+ id) );
	}
	
	@Override
	public Connection createConnection(Connection connection) {
		return saveConnection(connection);
	}
	
	public Connection saveConnection(Connection connection) {
		return connectionRepository.save(connection);
	}
	
	
}*/
