package controlador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import modelo.ProgAcad;
import modelo.ProgAcadDAO;
import modelo.AspiranteDAO;
import modelo.Aspirante;
;

@Named("asp")
@SessionScoped
public class AspiranteBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Aspirante dto = new Aspirante();
    private ArrayList<Aspirante> listaAs = AspiranteDAO.lista_A;
    private ArrayList<ProgAcad> listaPa;

    public AspiranteBean() {
        ProgAcadDAO.cargaDatos();
        listaPa = ProgAcadDAO.lista_P; 
        dto.setPro_acad(new ProgAcad());
    }

    public Aspirante getDto() { return dto; }
    public void setDto(Aspirante dto) { this.dto = dto; }

    public ArrayList<Aspirante> getListaAs() { return listaAs; }
    public void setListaAs(ArrayList<Aspirante> listaAs) { this.listaAs = listaAs; }

    public ArrayList<ProgAcad> getListaPa() { return listaPa; }
    public void setListaPa(ArrayList<ProgAcad> listaPa) { this.listaPa = listaPa; }

    public void registrar() {

        if (dto.getPro_acad().getCod() == -1) {
            System.out.println("Seleccione un programa");
            return;
        }

        dto.setFecha_reg(LocalDate.now());

        ProgAcad programaSeleccionado = null;

        for (ProgAcad p : listaPa) {
            if (p.getCod() == dto.getPro_acad().getCod()) {
                programaSeleccionado = p;
                break;
            }
        }

        dto.setPro_acad(programaSeleccionado);

        listaAs.add(dto);

        System.out.println("Se registró: " + dto.toString());

        dto = new Aspirante();
        dto.setPro_acad(new ProgAcad());
    }
}
