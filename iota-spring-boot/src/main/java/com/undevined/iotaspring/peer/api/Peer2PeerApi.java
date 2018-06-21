package com.undevined.iotaspring.peer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.undevined.iotaspring.Constants;
import com.undevined.iotaspring.peer.NodeService;

import jota.dto.response.GetNeighborsResponse;
import jota.dto.response.GetNodeInfoResponse;

@RestController
public class Peer2PeerApi {

	@Autowired
	private NodeService nodesService;
	
	@RequestMapping(path = Constants.Paths.NEIGHBORS, method = RequestMethod.GET)
	public GetNeighborsResponse getNeighbors() {
		return nodesService.getAllNeighbors();
	}
	
	@RequestMapping(path = Constants.Paths.NODEINFO, method = RequestMethod.GET)
	public GetNodeInfoResponse getNodeInfo() {
		return nodesService.getNodeInfo();
	}

}
