package com.kinghub.aerospike;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;

public class Write {
	public WritePolicy policy = null;
	public Key key = null;
	public Bin bin = null;
	
	public Write(String nameSpace, String setName, String key_,
			String name, String value) {
		this.policy = new WritePolicy();
		this.key = new Key(nameSpace, setName, key_);
		this.bin = new Bin(name, value);
	}
	public void write(AerospikeClient client, WritePolicy policy, 
			Key key, Bin bin) {
		client.put(policy, key, bin);
	}

}
