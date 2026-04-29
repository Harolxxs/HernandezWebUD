package controlador;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import modelo.ProgAcad;
import modelo.ProgAcadDAO;


@FacesConverter(value = "progAcadConverter", managed = true)
public class ProgAcadConverter implements Converter<ProgAcad> {

    @Override
    public ProgAcad getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null || value.isEmpty()) {
            return null;
        }

        for (ProgAcad p : ProgAcadDAO.lista_P) {
            if (String.valueOf(p.getCod()).equals(value)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, ProgAcad prog) {

        if (prog == null) {
            return "";
        }

        return String.valueOf(prog.getCod());
    }
}
