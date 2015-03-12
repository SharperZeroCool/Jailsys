package br.com.jailsys.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import br.com.jailsys.model.EntidadeComum;

@FacesConverter(value = "pickListConverter")
public class PickListConverter implements Converter {
    public final String EMPTY = "";
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        Object ret = null;
        if (component instanceof PickList) {
            DualListModel dualList = (DualListModel) ((PickList) component).getValue();
            for (Object o : dualList.getSource()) {
                String id = ((EntidadeComum) o).getId().toString();
                if (value.equals(id)) {
                    ret = o;
                    break;
                }
            }
            if (ret == null) {
                for (Object o : dualList.getTarget()) {
                    String id = ((EntidadeComum) o).getId().toString();
                    if (value.equals(id)) {
                        ret = o;
                        break;
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        return value instanceof EntidadeComum ? ((EntidadeComum) value).getId().toString() : EMPTY;
    }
}
