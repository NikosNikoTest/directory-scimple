/*
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at

* http://www.apache.org/licenses/LICENSE-2.0

* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.apache.directory.scim.server.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.apache.directory.scim.spec.protocol.Constants;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Adds JacksonJaxbJsonProvider for custom MediaType {@code application/scim+json}.
 */
@Provider
@Consumes(Constants.SCIM_CONTENT_TYPE)
@Produces(Constants.SCIM_CONTENT_TYPE)
public class ScimJacksonJaxbJsonProvider extends JacksonJaxbJsonProvider implements ContextResolver<ObjectMapper> {

  private final ObjectMapper objectMapper;

  @Inject
  public ScimJacksonJaxbJsonProvider(ObjectMapper objectMapper) {
    super(objectMapper, DEFAULT_ANNOTATIONS);
    this.objectMapper = objectMapper;
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return objectMapper;
  }
}
