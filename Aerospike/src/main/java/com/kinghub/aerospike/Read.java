package com.kinghub.aerospike;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.Policy;

public class Read {
	public Record read(AerospikeClient client, Policy policy, Key key) {
		return client.get(policy, key);
	}

}
