/**
 * 
 */
package org.gwtplugin.client;

import org.gwtplugin.client.plugin.Plugin;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class MySecondPlugin implements Plugin {

	@Override
	public String getName() {
		return getClass().getName();
	}

	@Override
	public void activate() {
		System.out.println("Plugin 2 active!");
	}

}
