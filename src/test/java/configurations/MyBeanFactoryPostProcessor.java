package configurations;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final String SCOPE_ANNOTATION = Scope.class.getCanonicalName();
    private String scope = ConfigurableBeanFactory.SCOPE_SINGLETON;

    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        for (String beanName : factory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            if (beanDefinition instanceof ScannedGenericBeanDefinition) {
                if (!((ScannedGenericBeanDefinition) beanDefinition).getMetadata().hasAnnotation(SCOPE_ANNOTATION)) {
                    beanDefinition.setScope(scope);
                }
            }
        }
    }
    public void setScope(String scope) {
        this.scope = scope;
    }
}


