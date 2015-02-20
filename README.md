# camel-guice-registry

* bind your objects with CamelBind annotation in the Guice Module
```java
bind(ClassOrIterfaceName.class).annotatedWith(Binds.camelBind("bean_name")).to(ClassName.class)
```

* include RegistryModule when creating the injector

* annotate injected parameters with CamelBind
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

* in the java DSL
```java
from("direct:test").beanRef("bean_name");
//or
from("direct:test").bean("bean:bean_name");
```
