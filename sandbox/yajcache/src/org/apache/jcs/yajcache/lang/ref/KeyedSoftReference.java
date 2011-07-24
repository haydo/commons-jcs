
/*
 * Copyright 2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
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
package org.apache.jcs.yajcache.lang.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import org.apache.jcs.yajcache.lang.annotation.*;

/**
 * {@link SoftReference} with an embedded key.
 *
 * @author Hanson Char
 */
@CopyRightApache
public class KeyedSoftReference<K,T> extends SoftReference<T> 
        implements IKey<K> 
{
    /** The embedded key. */
    private final @NonNullable @Immutable K key;
    
    /**
     * Creates a new soft reference with an embedded key that refers to 
     * the given object.  The new
     * reference is not registered with any queue.
     *
     * @param key the embedded key of the new soft reference
     * @param referent object the new soft reference will refer to
     */
    public KeyedSoftReference(@NonNullable @Immutable K key, T referent) 
    {
	super(referent);
        this.key = key;
    }
    /**
     * Creates a new soft reference with an embedded key that refers to 
     * the given object and is registered with the given queue.
     *
     * @param key the embedded key of the new soft reference
     * @param referent object the new soft reference will refer to
     * @param q the queue with which the reference is to be registered,
     *          or <tt>null</tt> if registration is not required
     */
    public KeyedSoftReference(@NonNullable @Immutable K key, T referent, 
            ReferenceQueue<? super T> q) 
    {
        super(referent, q);
        this.key = key;
    }
    @Implements(IKey.class)
    public @NonNullable @Immutable K getKey() {
        return this.key;
    }
}