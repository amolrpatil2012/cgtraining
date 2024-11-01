package lookupdemo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Role {
	private String name;
    public String getName() {
        return name;
       
    }
    public void setName(String name) {
        this. name = name;
    }
}
