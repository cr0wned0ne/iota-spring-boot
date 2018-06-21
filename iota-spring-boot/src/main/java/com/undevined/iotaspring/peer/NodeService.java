package com.undevined.iotaspring.peer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jota.IotaAPI;
import jota.dto.response.GetNeighborsResponse;
import jota.dto.response.GetNodeInfoResponse;

/**
 * Service that initializes this node.
 *
 */
@Component
public class NodeService {

	
	@Autowired
	private IotaAPI iotaApi;

	
	public GetNeighborsResponse getAllNeighbors() {
		GetNeighborsResponse neighbors = iotaApi.getNeighbors();
		return neighbors;
	}
	
	public GetNodeInfoResponse getNodeInfo() {
		return iotaApi.getNodeInfo();
	}
}
