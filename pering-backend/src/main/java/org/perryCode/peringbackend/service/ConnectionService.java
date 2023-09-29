package org.perryCode.peringbackend.service;

import java.util.List;

import org.perryCode.peringbackend.entity.Connection;

public interface ConnectionService {

	List<Connection> getAllConnections();
	Connection getConnectionById();
	Connection createConnection();
	Connection updateConnection();
	
}
