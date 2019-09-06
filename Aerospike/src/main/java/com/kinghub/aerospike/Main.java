package com.kinghub.aerospike;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Host;
import com.aerospike.client.Record;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.Policy;

public class Main {
	
	public static void main(String[] args) {
		
		Host[] hosts = new Host[] {
				new Host("192.168.0.101", 3000),
				new Host("127.0.0.1", 3000)
//				new Host("another.one.host", 3000)	
		};
		
		ClientPolicy policy = new ClientPolicy();
		AerospikeClient client = new AerospikeClient(policy, hosts);
		
		Write writeObject = new Write("test", "myset", "mykey", "bin1", "bin1_value1");
		writeObject.write(client, writeObject.policy, writeObject.key, writeObject.bin);
	
		Read readObject = new Read();
		Record record = readObject.read(client, new Policy(), writeObject.key);
		
		System.out.println(record.getString("bin1"));
		
		client.close();
	}
}

