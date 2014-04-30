package org.apache.commons.jcs.auxiliary.remote.behavior;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.jcs.auxiliary.remote.value.RemoteCacheRequest;
import org.apache.commons.jcs.auxiliary.remote.value.RemoteCacheResponse;

/**
 * In the future, this can be used as a generic dispatcher abstraction.
 * <p>
 * At the time of creation, only the http remote cache uses it. The RMI remote could be converted to
 * use it as well.
 */
public interface IRemoteCacheDispatcher
{
    /**
     * All requests will go through this method. The dispatcher implementation will send the request
     * remotely.
     * <p>
     * @param remoteCacheRequest
     * @return RemoteCacheResponse
     * @throws IOException
     */
    <K extends Serializable, V extends Serializable, T>
        RemoteCacheResponse<T> dispatchRequest( RemoteCacheRequest<K, V> remoteCacheRequest )
            throws IOException;
}