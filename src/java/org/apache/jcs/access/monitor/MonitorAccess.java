package org.apache.jcs.access.monitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Arrays;

import org.apache.jcs.engine.behavior.ICache;
import org.apache.jcs.access.GroupCacheAccess;
import org.apache.jcs.engine.control.group.GroupCacheManager;
import org.apache.jcs.engine.control.group.GroupCacheManager;
import org.apache.jcs.engine.control.group.GroupCacheManager;
import org.apache.jcs.engine.control.group.GroupCacheManagerFactory;
import org.apache.jcs.engine.control.group.GroupCacheManagerFactory;
import org.apache.jcs.engine.control.group.GroupCacheManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Exposes the simple monitoring methods to the public in a simple manner.
 *
 * @author asmuts
 * @created February 12, 2002
 */
public class MonitorAccess implements Serializable
{
    private final static Log log =
        LogFactory.getLog( MonitorAccess.class );

    /** Description of the Field */
    protected GroupCacheManager cacheMgr;

    /** Constructor for the MonitorAccess object */
    public MonitorAccess()
    {

        if ( cacheMgr == null )
        {
            synchronized ( GroupCacheAccess.class )
            {
                if ( cacheMgr == null )
                {
                    cacheMgr = GroupCacheManagerFactory.getInstance();
                }
            }
        }
    }


    /** Description of the Method */
    public String delete( String cacheName, String key )
    {

        // some junk to return for a synchronous call
        String result = "";

        try
        {

            ICache cache = cacheMgr.getCache( cacheName );

            if ( key != null )
            {
                if ( key.toUpperCase().equals( "ALL" ) )
                {
                    cache.removeAll();

                    if ( log.isDebugEnabled() )
                    {
                        log.debug( "Removed all elements from " + cacheName );
                    }
                    result = "key = " + key;
                }
                else
                {
                    if ( log.isDebugEnabled() )
                    {
                        log.debug( "key = " + key );
                    }
                    result = "key = " + key;
                    StringTokenizer toke = new StringTokenizer( key, "_" );

                    while ( toke.hasMoreElements() )
                    {
                        String temp = ( String ) toke.nextElement();
                        cache.remove( key );

                        if ( log.isDebugEnabled() )
                        {
                            log.debug( "Removed " + temp + " from " + cacheName );
                        }
                    }
                }
            }
            else
            {
                result = "key is null";
            }

        }
        catch ( Exception e )
        {
            log.error( e );
        }

        return result;
    }

    /** Description of the Method */
    public String stats( String cacheName )
    {

        ICache cache = cacheMgr.getCache( cacheName );

        return cache.getStats();
    }


    /** Description of the Method */
    public ArrayList overview()
    {

        ArrayList data = new ArrayList();

        String[] list = cacheMgr.getCacheNames();
        Arrays.sort( list );
        for ( int i = 0; i < list.length; i++ )
        {
            Hashtable ht = new Hashtable();
            String name = list[i];
            ht.put( "name", name );

            ICache cache = cacheMgr.getCache( name );
            int size = cache.getSize();
            ht.put( "size", Integer.toString( size ) );

            int status = cache.getStatus();
            String stat = status == ICache.STATUS_ALIVE ? "ALIVE"
                 : status == ICache.STATUS_DISPOSED ? "DISPOSED"
                 : status == ICache.STATUS_ERROR ? "ERROR"
                 : "UNKNOWN";
            ht.put( "stat", stat );

            data.add( ht );
        }
        return data;
    }

}
