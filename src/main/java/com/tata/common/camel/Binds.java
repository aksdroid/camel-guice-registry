package com.tata.common.camel;


/*
 * helper Class to use with CamelBind
 * 
 * @author chelfim@google.com (Mourad Chelfi)
 */
public class Binds
{
    /**
     * Creates a {@link CamelBind} annotation with {@code name} as the value.
     */
    public static CamelBind camelBind(String name) 
    {
        return new CamelBindImpl(name);
    }
}
