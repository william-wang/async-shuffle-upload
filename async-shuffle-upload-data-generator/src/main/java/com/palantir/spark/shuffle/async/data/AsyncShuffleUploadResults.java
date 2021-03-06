/*
 * (c) Copyright 2019 Palantir Technologies Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.palantir.spark.shuffle.async.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.palantir.spark.shuffle.async.data.config.DataGeneratorConfig;
import com.palantir.spark.shuffle.async.immutables.ImmutablesStyle;
import org.immutables.value.Value;

@Value.Immutable
@ImmutablesStyle
@JsonSerialize(as = ImmutableAsyncShuffleUploadResults.class)
@JsonDeserialize(as = ImmutableAsyncShuffleUploadResults.class)
public interface AsyncShuffleUploadResults {

    DataGeneratorConfig config();

    String baseUri();

    double readThroughputBytesPerSec();

    double writeThroughputBytesPerSec();

    class Builder extends ImmutableAsyncShuffleUploadResults.Builder {}

    static Builder builder() {
        return new Builder();
    }
}
