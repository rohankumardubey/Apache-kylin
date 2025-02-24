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
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.kylin.rest.config;

import org.apache.kylin.common.scheduler.EventBusFactory;
import org.apache.kylin.rest.config.cloud.AlluxioExtension;
import org.apache.kylin.rest.config.initialize.AfterMetadataReadyEvent;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "kylin.env.channel", havingValue = "cloud")
public class CloudConfig implements ApplicationListener<AfterMetadataReadyEvent> {

    @Override
    public void onApplicationEvent(AfterMetadataReadyEvent event) {
        EventBusFactory.getInstance().register(new AlluxioExtension(), true);
    }
}
