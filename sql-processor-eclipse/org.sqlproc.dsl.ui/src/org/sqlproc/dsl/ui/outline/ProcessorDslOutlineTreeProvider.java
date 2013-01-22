/*
 * generated by Xtext
 */
package org.sqlproc.dsl.ui.outline;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.sqlproc.dsl.processorDsl.Artifacts;
import org.sqlproc.dsl.processorDsl.Column;
import org.sqlproc.dsl.processorDsl.Constant;
import org.sqlproc.dsl.processorDsl.DatabaseColumn;
import org.sqlproc.dsl.processorDsl.Identifier;
import org.sqlproc.dsl.processorDsl.MappingColumn;
import org.sqlproc.dsl.processorDsl.MappingRule;
import org.sqlproc.dsl.processorDsl.MetaStatement;
import org.sqlproc.dsl.processorDsl.OptionalFeature;
import org.sqlproc.dsl.util.Collector;
import org.sqlproc.dsl.util.Utils;

/**
 * customization of the default outline structure
 * 
 */
public class ProcessorDslOutlineTreeProvider extends DefaultOutlineTreeProvider {

    @Override
    protected void _createChildren(DocumentRootNode parentNode, EObject rootElement) {
        // for (EObject content : rootElement.eContents()) {
        // createNode(parentNode, content);
        // }

        Artifacts artifacts = (Artifacts) rootElement;
        if (artifacts.getFeatures() != null) {
            for (OptionalFeature optionalFeature : artifacts.getFeatures()) {
                createNode(parentNode, optionalFeature);
            }
        }
        if (artifacts.getStatements() != null) {
            for (MetaStatement metaStatement : artifacts.getStatements()) {
                createNode(parentNode, metaStatement);
            }
        }
        if (artifacts.getMappings() != null) {
            for (MappingRule mappingRule : artifacts.getMappings()) {
                createNode(parentNode, mappingRule);
            }
        }
    }

    @Override
    protected void _createChildren(IOutlineNode parentNode, EObject modelElement) {

        if (modelElement instanceof MetaStatement) {
            Set<Identifier> identifiers = new TreeSet<Identifier>(new Comparator<Identifier>() {

                @Override
                public int compare(Identifier o1, Identifier o2) {
                    return Utils.getName(o1).compareTo(Utils.getName(o2));
                }
            });
            Set<Constant> constants = new TreeSet<Constant>(new Comparator<Constant>() {

                @Override
                public int compare(Constant o1, Constant o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            Set<Column> columns = new TreeSet<Column>(new Comparator<Column>() {

                @Override
                public int compare(Column o1, Column o2) {
                    return Utils.getName(o1).compareTo(Utils.getName(o2));
                }
            });
            Set<DatabaseColumn> databaseColumns = new TreeSet<DatabaseColumn>(new Comparator<DatabaseColumn>() {

                @Override
                public int compare(DatabaseColumn o1, DatabaseColumn o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            Collector.allVariables((MetaStatement) modelElement, identifiers, constants, columns, databaseColumns);
            if (!identifiers.isEmpty()) {
                for (Identifier identifier : identifiers) {
                    createNode(parentNode, identifier);
                }
            }
            if (!constants.isEmpty()) {
                for (Constant constant : constants) {
                    createNode(parentNode, constant);
                }
            }
            if (!columns.isEmpty()) {
                for (Column column : columns) {
                    createNode(parentNode, column);
                }
            }
            if (!databaseColumns.isEmpty()) {
                for (DatabaseColumn column : databaseColumns) {
                    createNode(parentNode, column);
                }
            }
        } else if (modelElement instanceof MappingRule) {
            Set<MappingColumn> columns = new TreeSet<MappingColumn>(new Comparator<MappingColumn>() {

                @Override
                public int compare(MappingColumn o1, MappingColumn o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            Collector.allVariables((MappingRule) modelElement, columns);
            if (!columns.isEmpty()) {
                for (MappingColumn column : columns) {
                    createNode(parentNode, column);
                }
            }
        }
    }

    protected boolean _isLeaf(MetaStatement metaStatement) {
        return false;
    }

    protected boolean _isLeaf(MappingRule mappingRule) {
        return false;
    }

    protected boolean _isLeaf(OptionalFeature optionalFeature) {
        return true;
    }

    protected boolean _isLeaf(Identifier identifier) {
        return true;
    }

    protected boolean _isLeaf(Constant constant) {
        return true;
    }

    protected boolean _isLeaf(Column column) {
        return true;
    }

    protected boolean _isLeaf(DatabaseColumn column) {
        return true;
    }

    protected boolean _isLeaf(MappingColumn column) {
        return true;
    }
}
