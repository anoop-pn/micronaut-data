/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.data.intercept;

import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.annotation.Introspected;
import edu.ucr.cs.riple.taint.ucrtainting.qual.RUntainted;

/**
 * Marker interface for all Data related interceptors.
 *
 * @param <T> The declaring type
 * @param <R> The return type
 *
 * @author graemerocher
 * @since 1.0
 */
@Introspected
public interface DataInterceptor<T, R> {

    /**
     * Intercepts a data method execution.
     *
     * @param methodKey The method key
     * @param context The context
     * @return The result
     */
    R intercept(RepositoryMethodKey methodKey, @RUntainted MethodInvocationContext<T, R> context);
}
