/*
 * Copyright (C) The Apache Software Foundation. All rights reserved.
 *
 * This software is published under the terms of the Apache Software License
 * version 1.1, a copy of which has been included with this distribution in
 * the LICENSE file.
 */
package org.apache.jcs.auxiliary.disk.jisp;

import org.apache.jcs.auxiliary.behavior.IAuxiliaryCacheAttributes;
import org.apache.jcs.auxiliary.behavior.IAuxiliaryCacheFactory;

import org.apache.jcs.auxiliary.disk.jisp.behavior.IJISPCacheAttributes;

import org.apache.jcs.engine.behavior.ICache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Aaron Smuts
 * @created January 15, 2002
 * @version 1.0
 */

public class JISPCacheFactory implements IAuxiliaryCacheFactory
{
    private final static Log log =
        LogFactory.getLog( JISPCacheFactory.class );

    private static String name;

    /** Constructor for the JISPCacheFactory object */
    public JISPCacheFactory() { }


    /** Description of the Method */
    public ICache createCache( IAuxiliaryCacheAttributes iaca )
    {
        IJISPCacheAttributes idca = ( IJISPCacheAttributes ) iaca;
        JISPCacheManager dcm = JISPCacheManager.getInstance( idca );
        return dcm.getCache( idca );
    }


    /**
     * Gets the name attribute of the JISPCacheFactory object
     *
     * @return The name value
     */
    public String getName()
    {
        return this.name;
    }


    /**
     * Sets the name attribute of the JISPCacheFactory object
     *
     * @param name The new name value
     */
    public void setName( String name )
    {
        this.name = name;
    }
}
