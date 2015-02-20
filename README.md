# camel-guice-registry

1. bind your objects with CamelBind annotation in the Guice Module
```java
bind(ClassOrIterfaceName.class).annotatedWith(Binds.camelBind("bean_name")).to(ClassName.class)
```

2. include RegistryModule when creating the injector

3. annotate injected parameters with CamelBind
```java
public class Example
{ 
   ...
   @Inject
   public Example(@CamelBind("bean_name")  ClassOrIterfaceName param)
   {
     ...
   }
   ....
}
```

4. in the java DSL
```java
from("direct:test").beanRef("bean_name");
//or
from("direct:test").bean("bean:bean_name");
```
