package com.tata.common.camel;

import java.sql.SQLException;

import javax.inject.Singleton;

import org.apache.camel.guice.CamelModuleWithMatchingRoutes;
import org.apache.camel.impl.CompositeRegistry;
import org.apache.camel.spi.Registry;

import com.google.inject.Injector;
import com.google.inject.Provides;


public class RegistryModule extends CamelModuleWithMatchingRoutes
{

    @Override
    protected void configure()
    {
        super.configure();
               
        bind(Registry.class).to(CompositeRegistry.class);
    }
    
    @Provides    
    @Singleton
    public CompositeRegistry getRegistry(Injector injector) throws SQLException
    {
        CompositeRegistry compositeRegistry = new CompositeRegistry();   
        
        compositeRegistry.addRegistry( new GuiceRegistry(injector));
        
        Injector parentInjector = injector.getParent();
        if(parentInjector != null)
        {
            GuiceRegistry parentRegistry = parentInjector.getInstance(GuiceRegistry.class);
            compositeRegistry.addRegistry(parentRegistry);
        }
        
        return compositeRegistry;
    }
}
