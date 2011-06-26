/*
 * generated by Xtext
 */
package org.sqlproc.dsl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.sqlproc.dsl.processorDsl.Artifacts;
import org.sqlproc.dsl.processorDsl.Column;
import org.sqlproc.dsl.processorDsl.Constant;
import org.sqlproc.dsl.processorDsl.DatabaseColumn;
import org.sqlproc.dsl.processorDsl.Identifier;
import org.sqlproc.dsl.processorDsl.MappingColumn;
import org.sqlproc.dsl.processorDsl.MappingRule;
import org.sqlproc.dsl.processorDsl.MetaStatement;
import org.sqlproc.dsl.processorDsl.OptionalFeature;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ProcessorDslLabelProvider extends DefaultEObjectLabelProvider {

    @Inject
    public ProcessorDslLabelProvider(AdapterFactoryLabelProvider delegate) {
        super(delegate);
    }

    public String text(Artifacts ele) {
        return "MODEL";
    }

    public String text(MetaStatement ele) {
        return ele.getName();
    }

    public String text(MappingRule ele) {
        return ele.getName();
    }

    public String text(OptionalFeature ele) {
        return ele.getName();
    }

    public String text(Identifier ele) {
        return ele.getName();
    }

    public String text(Constant ele) {
        return ele.getName();
    }

    public String text(Column ele) {
        return ele.getName();
    }

    public String text(MappingColumn ele) {
        return ele.getName();
    }

    public String text(DatabaseColumn ele) {
        return ele.getName();
    }

    String image(MetaStatement ele) {
        return "SQL.gif";
    }

    String image(MappingRule ele) {
        return "OUT.gif";
    }

    String image(OptionalFeature ele) {
        return "OPT.gif";
    }

    String image(Identifier ele) {
        return "IDNT.gif";
    }

    String image(Constant ele) {
        return "CNST.gif";
    }

    String image(Column ele) {
        return "COL.gif";
    }

    String image(MappingColumn ele) {
        return "COL.gif";
    }

    String image(DatabaseColumn ele) {
        return "DBCOL.gif";
    }
}
