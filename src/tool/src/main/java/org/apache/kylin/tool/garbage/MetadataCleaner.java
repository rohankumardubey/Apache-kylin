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

package org.apache.kylin.tool.garbage;

public abstract class MetadataCleaner {
    protected final String project;

    protected MetadataCleaner(String project) {
        this.project = project;
    }

    // do in transaction
    public abstract void beforeCleanup();

    // do in transaction
    public abstract void cleanup();

    // do in transaction
    public abstract void afterCleanup();

    public void prepare() {
        // default do nothing
    }
}
