/*
 * $Id$
 *
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.struts2.util;

import com.opensymphony.xwork.config.Configuration;
import com.opensymphony.xwork.config.entities.PackageConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.struts2.dispatcher.DispatcherUtils;
import org.apache.struts2.dispatcher.DispatcherListener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * A Servlet Context Listener that will loop through all Reference Resolvers available in
 * the xwork Configuration and set the ServletContext on those that are ServletContextAware.
 * The Servlet Context can be used by the External Reference Resolver to initialise it's state. i.e. the
 * Spring framework uses a ContextServletListener to initialise it's IoC container, storing it's
 * container context (ApplicationContext in Spring terms) in the Servlet context, the External
 * Reference Resolver can get a reference to the container context from the servlet context.
 */
public class ResolverSetupServletContextListener implements ServletContextListener {

    Map<ServletContext,Listener> listeners = new HashMap<ServletContext,Listener>();
    
    public synchronized void contextDestroyed(ServletContextEvent event) {
        Listener l = listeners.get(event.getServletContext());
        DispatcherUtils.removeDispatcherListener(l);
        listeners.remove(event.getServletContext());
    }

    public synchronized void contextInitialized(ServletContextEvent event) {
        Listener l = new Listener(event.getServletContext());
        DispatcherUtils.addDispatcherListener(l);
        listeners.put(event.getServletContext(), l);
    }
    
    private class Listener implements DispatcherListener {

        private ServletContext servletContext;
        
        public Listener(ServletContext ctx) {
            this.servletContext = ctx;
        }
        
        public void dispatcherInitialized(DispatcherUtils du) {
            Configuration config = du.getConfigurationManager().getConfiguration();
            String key;
            PackageConfig packageConfig;

            for (Iterator iter = config.getPackageConfigNames().iterator();
                 iter.hasNext();) {
                key = (String) iter.next();
                packageConfig = config.getPackageConfig(key);

                if (packageConfig.getExternalRefResolver()instanceof ServletContextAware) {
                    ((ServletContextAware) packageConfig.getExternalRefResolver()).setServletContext(servletContext);
                }
            }
            
        }

        public void dispatcherDestroyed(DispatcherUtils du) {
        }
    }
}
