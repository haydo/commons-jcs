package org.apache.jcs.auxiliary.disk.indexed;

/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in
 * the documentation and/or other materials provided with the
 * distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 * any, must include the following acknowlegement:
 * "This product includes software developed by the
 * Apache Software Foundation (http://www.apache.org/)."
 * Alternately, this acknowlegement may appear in the software itself,
 * if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Velocity", and "Apache Software
 * Foundation" must not be used to endorse or promote products derived
 * from this software without prior written permission. For written
 * permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 * nor may "Apache" appear in their names without prior written
 * permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
import org.apache.jcs.auxiliary.behavior.IAuxiliaryCacheAttributes;

import org.apache.jcs.auxiliary.disk.indexed.behavior.IIndexedDiskCacheAttributes;

/**
 * Configuration class for the Indexed Disk Cache
 *
 * @author asmuts
 * @created January 15, 2002
 */
public class IndexedDiskCacheAttributes implements IIndexedDiskCacheAttributes
{

    private String cacheName;
    private String name;

    private String diskPath;


    /**
     * Constructor for the DiskCacheAttributes object
     */
    public IndexedDiskCacheAttributes()
    {
    }


    /**
     * Sets the diskPath attribute of the DiskCacheAttributes object
     *
     * @param path The new diskPath value
     */
    public void setDiskPath( String path )
    {
        this.diskPath = path;
    }


    /**
     * Gets the diskPath attribute of the DiskCacheAttributes object
     *
     * @return The diskPath value
     */
    public String getDiskPath()
    {
        return this.diskPath;
    }


    /**
     * Sets the cacheName attribute of the DiskCacheAttributes object
     *
     * @param s The new cacheName value
     */
    public void setCacheName( String s )
    {
        this.cacheName = s;
    }


    /**
     * Gets the cacheName attribute of the DiskCacheAttributes object
     *
     * @return The cacheName value
     */
    public String getCacheName()
    {
        return this.cacheName;
    }


    /**
     * Gets the name attribute of the DiskCacheAttributes object
     *
     * @return The name value
     */
    public String getName()
    {
        return this.name;
    }


    /**
     * Sets the name attribute of the DiskCacheAttributes object
     *
     * @param name The new name value
     */
    public void setName( String name )
    {
        this.name = name;
    }


    /**
     * Description of the Method
     *
     * @return
     */
    public IAuxiliaryCacheAttributes copy()
    {
        try
        {
            return ( IAuxiliaryCacheAttributes ) this.clone();
        }
        catch ( Exception e )
        {
        }
        return ( IAuxiliaryCacheAttributes ) this;
    }


    /**
     * Description of the Method
     *
     * @return
     */
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append( "diskPath = " + diskPath );
        return str.toString();
    }

}
