package com.undevined.iotaspring;

import java.util.ArrayList;
import java.util.List;

import com.undevined.iotaspring.iota.IotaConfig;
import com.undevined.iotaspring.iota.IotaProperties;

import jota.IotaAPI;
import jota.dto.response.GetBalancesAndFormatResponse;
import jota.dto.response.GetNodeInfoResponse;
import jota.dto.response.GetTrytesResponse;
import jota.dto.response.SendTransferResponse;
import jota.error.ArgumentException;
import jota.model.Input;
import jota.model.Transfer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	private static String TEST_SEED = "HELLOWORLDHELLOWORLDHELLOWORLDCDLLOWORLDHELLOWORLDHELLOWORLDHELLOWORLDHELLOWORLDD";
	private static final String TEST_MESSAGE = "WDFERTERTERTERTERTT";
	private static final String TEST_TAG = "DCDTSISPAM99999999999999999";

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Test connection to iota test net.
	 */
	public void testIotaConnection() {

		GetNodeInfoResponse nodeInfo = getIotaApi().getNodeInfo();
		System.out.println(nodeInfo.toString());
	}

	/**
	 * Test getting the balance for the seed.
	 */
	public void testGetInputs() {
		try {
			GetBalancesAndFormatResponse inputs = getIotaApi().getInputs(TEST_SEED, 2, 0, 0, 0);
			assertNotNull(inputs);
			System.out.println(inputs.toString());
		} catch (ArgumentException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test sending a helloworld transaction.
	 */
	public void testSendTransaction() {
		int security = 2;
		int depth = 9;
		int minWeightMagnitude = 9;
		List<Transfer> transfers = new ArrayList<Transfer>();
		Transfer transfer = new Transfer(TEST_SEED, 000);

		transfers.add(transfer);
		List<Input> inputs = null;
		String remainderAddress = null;
		boolean validateInputs = false;
		try {
			SendTransferResponse response = getIotaApi().sendTransfer(TEST_SEED, security, depth, minWeightMagnitude,
					transfers, inputs, remainderAddress, validateInputs);
			System.out.println(response.toString());
		} catch (ArgumentException e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testTransactionWithTag() {
		int security = 2;
		int depth = 9;
		int minWeightMagnitude = 9;
		List<Transfer> transfers = new ArrayList<Transfer>();
		Transfer transfer = new Transfer(TEST_SEED, 0, TEST_MESSAGE, TEST_TAG);

		transfers.add(transfer);
		List<Input> inputs = null;
		String remainderAddress = null;
		boolean validateInputs = false;
		try {
			SendTransferResponse response = getIotaApi().sendTransfer(TEST_SEED, security, depth, minWeightMagnitude,
					transfers, inputs, remainderAddress, validateInputs);
			System.out.println(response.toString());
		} catch (ArgumentException e) {
			e.printStackTrace();
			fail();
		}
	}

	private IotaAPI getIotaApi() {
		IotaProperties properties = new IotaProperties();
		properties.setProtocol("https");
		properties.setHost("nodes.testnet.iota.org");
		properties.setPort(443);
		IotaConfig config = new IotaConfig(properties);
		return config.iotaApi();
	}
}
