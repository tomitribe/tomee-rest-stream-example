/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.superbiz;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.StreamingOutput;

import static javax.ejb.LockType.READ;

@Lock(READ)
@Singleton
@Path("/stream")
public class CoffeeService {

    @GET
    @Path("/coffee")
    public StreamingOutput getCoffee() {
        return outputStream -> {
            long beers = 0;
            while (true) {
                outputStream.write(String.format("%s coffees on the wall\r", beers++).getBytes());
            }
        };
    }
}
