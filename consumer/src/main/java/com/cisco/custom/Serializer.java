package com.cisco.custom;

import java.io.Closeable;
import java.util.Map;

public interface Serializer<T> extends Closeable,org.apache.kafka.common.serialization.Serializer<T> {
	  void configure(Map<String, ?> config, boolean isKey);
	  byte[] serialize(String topic, T data);
	  void close();
}
