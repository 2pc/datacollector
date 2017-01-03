/**
 * Copyright 2015 StreamSets Inc.
 *
 * Licensed under the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.streamsets.datacollector.runner.production;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public class SourceOffset {

  /**
   * Current version of the offset file.
   *
   * (nothing): First version with just "offset"
   * 1: Skipped to have nothing as "1"
   * 2: Added version and pushOffsets fields
   */
  public static final int CURRENT_VERSION = 2;

  /**
   * Version of this SourceOffset file
   */
  private int version;

  /**
   * Deprecated, available for backward compatibility
   */
  private String offset;

  /**
   * Offset map for all entities, in case of single-threaded origin the offset will be stored in null key
   */
  private Map<String, String> offsets;

  public SourceOffset() {
  }

  public SourceOffset(int version, Map<String, String> offsets) {
    this.version = version;
    this.offsets = offsets;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  @JsonIgnore
  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }

  public Map<String, String> getOffsets() {
    return offsets;
  }

  public void setOffsets(Map<String, String> offsets) {
    this.offsets = offsets;
  }
}
