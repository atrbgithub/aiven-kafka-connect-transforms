/*
 * Copyright 2019 Aiven Oy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.aiven.kafka.connect.transforms;

import java.util.Map;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

final class ExtractTimestampConfig extends AbstractConfig {
    public static final String FIELD_NAME_CONFIG = "field.name";
    private static final String FIELD_NAME_DOC =
        "The name of the field is to be used as the source of timestamp. "
            + "The field must have INT64 or org.apache.kafka.connect.data.Timestamp type "
            + "and must mot be null.";

    ExtractTimestampConfig(final Map<?, ?> originals) {
        super(config(), originals);
    }

    static ConfigDef config() {
        return new ConfigDef()
            .define(
                FIELD_NAME_CONFIG,
                ConfigDef.Type.STRING,
                ConfigDef.NO_DEFAULT_VALUE,
                new ConfigDef.NonEmptyString(),
                ConfigDef.Importance.HIGH,
                FIELD_NAME_DOC);
    }

    final String fieldName() {
        return getString(FIELD_NAME_CONFIG);
    }
}
