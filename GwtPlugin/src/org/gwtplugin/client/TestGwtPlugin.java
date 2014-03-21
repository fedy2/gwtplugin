package org.gwtplugin.client;

import org.gwtplugin.client.plugin.Plugin;
import org.gwtplugin.client.plugin.PluginProvider;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class TestGwtPlugin implements EntryPoint {

	PluginProvider pluginsProvider = GWT.create(PluginProvider.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		for (Plugin plugin:pluginsProvider.getPlugins()) plugin.activate();
	}
}
