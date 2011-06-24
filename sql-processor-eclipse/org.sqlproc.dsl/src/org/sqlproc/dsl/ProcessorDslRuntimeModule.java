/*
 * generated by Xtext
 */
package org.sqlproc.dsl;

import org.eclipse.xtext.parser.IAstFactory;
import org.sqlproc.dsl.property.ModelProperty;
import org.sqlproc.dsl.property.ModelPropertyBean;
import org.sqlproc.dsl.resolver.DbResolver;
import org.sqlproc.dsl.resolver.DbResolverBean;
import org.sqlproc.dsl.resolver.PojoResolverFactory;
import org.sqlproc.dsl.resolver.PojoResolverFactoryBean;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ProcessorDslRuntimeModule extends org.sqlproc.dsl.AbstractProcessorDslRuntimeModule {

    public Class<? extends ModelProperty> bindModelProperty() {
        return ModelPropertyBean.class;
    }

    public Class<? extends IAstFactory> bindIAstFactory() {
        return ProcessorEcoreElementFactory.class;
    }

    @Override
    public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
        return ProcessorNameProvider.class;
    }

    public Class<? extends PojoResolverFactory> bindPojoResolverFactory() {
        return PojoResolverFactoryBean.class;
    }

    public Class<? extends DbResolver> bindDbResolver() {
        return DbResolverBean.class;
    }
}
