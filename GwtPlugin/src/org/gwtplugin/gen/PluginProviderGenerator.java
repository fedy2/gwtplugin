/**
 * 
 */
package org.gwtplugin.gen;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gwtplugin.client.plugin.Plugin;

import com.google.gwt.core.ext.BadPropertyValueException;
import com.google.gwt.core.ext.ConfigurationProperty;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.PropertyOracle;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class PluginProviderGenerator extends Generator {
	
	private static final String PROPERTY_NAME = "plugins";

	@Override
	public String generate(TreeLogger logger, GeneratorContext context, String typeName) throws UnableToCompleteException {

		try {
			JClassType classType = context.getTypeOracle().getType(typeName);
			String packageName = classType.getPackage().getName();
			String simpleName = classType.getSimpleSourceName() + "Generated";
			PrintWriter printWriter = context.tryCreate(logger, packageName, simpleName);
			String name = typeName + "Generated";
			
			if (printWriter == null) return name;
			
			ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName, simpleName);
			composer.addImplementedInterface(classType.getName());

			composer.addImport(Plugin.class.getName());
			composer.addImport(List.class.getName());
			composer.addImport(ArrayList.class.getName());
			composer.addImport(Collections.class.getName());
			
			SourceWriter src = composer.createSourceWriter(context, printWriter);
			
			List<String> plugins = getPlugins(context.getPropertyOracle());

			src.println("public List<Plugin> getPlugins() {");
			src.indent();
			if (plugins.isEmpty()) src.println("return Collections.emptyList();");
			else {
				src.println("List<Plugin> plugins = new ArrayList<Plugin>("+plugins.size()+");");
				for (String plugin:plugins) {
					src.println("plugins.add(new "+plugin+"());");
				}
				src.println("return plugins;");

			}
			src.outdent();
			src.println("}");

			src.commit(logger);

			return typeName + "Generated";

		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new UnableToCompleteException();
		}
	}

	private List<String> getPlugins(PropertyOracle propertyOracle) {

		try {
			ConfigurationProperty propertyValue = propertyOracle.getConfigurationProperty(PROPERTY_NAME);
			return propertyValue.getValues();

		} catch (BadPropertyValueException e) {
			// intentional
		}
		return Collections.emptyList();
	}
}
