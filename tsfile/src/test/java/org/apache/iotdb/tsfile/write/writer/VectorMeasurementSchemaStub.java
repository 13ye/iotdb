/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.iotdb.tsfile.write.writer;

import org.apache.iotdb.tsfile.encoding.encoder.Encoder;
import org.apache.iotdb.tsfile.encoding.encoder.PlainEncoder;
import org.apache.iotdb.tsfile.file.metadata.enums.CompressionType;
import org.apache.iotdb.tsfile.file.metadata.enums.TSDataType;
import org.apache.iotdb.tsfile.file.metadata.enums.TSEncoding;
import org.apache.iotdb.tsfile.write.schema.IMeasurementSchema;

import java.util.Arrays;
import java.util.List;

public class VectorMeasurementSchemaStub implements IMeasurementSchema {

  @Override
  public String getMeasurementId() {
    return "s1.time";
  }

  @Override
  public CompressionType getCompressor() {
    return CompressionType.UNCOMPRESSED;
  }

  @Override
  public TSDataType getType() {
    return TSDataType.VECTOR;
  }

  @Override
  public TSEncoding getTimeTSEncoding() {
    return TSEncoding.PLAIN;
  }

  @Override
  public Encoder getTimeEncoder() {
    return new PlainEncoder(TSDataType.INT64, 0);
  }

  @Override
  public List<String> getValueMeasurementIdList() {
    return Arrays.asList("s1", "s2", "s3");
  }

  @Override
  public List<TSDataType> getValueTSDataTypeList() {
    return Arrays.asList(TSDataType.FLOAT, TSDataType.INT32, TSDataType.DOUBLE);
  }

  @Override
  public List<TSEncoding> getValueTSEncodingList() {
    return Arrays.asList(TSEncoding.PLAIN, TSEncoding.PLAIN, TSEncoding.PLAIN);
  }

  @Override
  public List<Encoder> getValueEncoderList() {
    return Arrays.asList(
        new PlainEncoder(TSDataType.FLOAT, 0),
        new PlainEncoder(TSDataType.INT32, 0),
        new PlainEncoder(TSDataType.DOUBLE, 0));
  }
}
