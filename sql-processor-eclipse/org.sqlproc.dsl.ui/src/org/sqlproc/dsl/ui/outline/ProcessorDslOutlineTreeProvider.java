/*
 * generated by Xtext
 */
package org.sqlproc.dsl.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.sqlproc.dsl.processorDsl.MappingRule;
import org.sqlproc.dsl.processorDsl.MetaStatement;
import org.sqlproc.dsl.processorDsl.OptionalFeature;

/**
 * customization of the default outline structure
 * 
 */
public class ProcessorDslOutlineTreeProvider extends DefaultOutlineTreeProvider {

    @Override
    protected void _createChildren(DocumentRootNode parentNode, EObject rootElement) {
        for (EObject content : rootElement.eContents()) {
            createNode(parentNode, content);
        }
    }

    protected boolean _isLeaf(MetaStatement metaStatement) {
        return true;
    }

    protected boolean _isLeaf(MappingRule mappingRule) {
        return true;
    }

    protected boolean _isLeaf(OptionalFeature optionalFeature) {
        return true;
    }
}
