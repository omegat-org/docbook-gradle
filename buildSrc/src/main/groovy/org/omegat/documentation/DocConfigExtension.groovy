/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.omegat.documentation

import groovy.transform.CompileStatic
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.model.ObjectFactory

import static groovy.lang.Closure.DELEGATE_FIRST

@CompileStatic
class DocConfigExtension {

    final DirectoryProperty styleDir
    final DirectoryProperty docRoot
    final DirectoryProperty outputRoot

    DocConfigExtension(ObjectFactory objectFactory) {
        styleDir = objectFactory.directoryProperty()
        docRoot = objectFactory.directoryProperty()
        outputRoot = objectFactory.directoryProperty()
    }

    void asciidocConfig(Closure cfg) {
        Closure configurator = (Closure) cfg.clone()
        configurator.resolveStrategy = DELEGATE_FIRST
        configurator.call()
    }
}
