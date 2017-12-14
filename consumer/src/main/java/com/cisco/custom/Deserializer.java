package com.cisco.custom;

import java.io.Closeable;
import java.util.Map;

public interface Deserializer<T> extends Closeable,org.apache.kafka.common.serialization.Deserializer<T> {
	  void configure(Map<String, ?> config, boolean isKey);
	  T deserialize(String topic, byte[] data);
	  void close();
}
