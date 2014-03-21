/**
 * 
 */
package org.gwtplugin.client.plugin;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public interface Plugin {
	
	/**
	 * Returns the plugin name.
	 * @return the plugin name.
	 */
	public String getName();
	
	/**
	 * Activates the plugin.
	 */
	public void activate();

}
