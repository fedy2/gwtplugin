/**
 * 
 */
package org.gwtplugin.client.plugin;

import java.util.List;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public interface PluginProvider {
	
	/**
	 * Returns all the plugin instance.
	 * @return the plugin instances.
	 */
	List<Plugin> getPlugins();

}
