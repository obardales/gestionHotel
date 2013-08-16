package pe.hotelho.hotel.controller;

import pe.hotelho.hotel.entidades.Orden;
import pe.hotelho.hotel.controller.util.JsfUtil;
import pe.hotelho.hotel.controller.util.PaginationHelper;
import pe.hotelho.hotel.facade.OrdenFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("ordenController")
@SessionScoped
public class OrdenController implements Serializable {

    private Orden current;
    private DataModel items = null;
    @EJB
    private pe.hotelho.hotel.facade.OrdenFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public OrdenController() {
    }

    public Orden getSelected() {
        if (current == null) {
            current = new Orden();
            current.setOrdenPK(new pe.hotelho.hotel.entidades.OrdenPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private OrdenFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {
                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Orden) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Orden();
        current.setOrdenPK(new pe.hotelho.hotel.entidades.OrdenPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getOrdenPK().setIdautorizacion(current.getAutorizacion().getIdautorizacion());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("OrdenCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Orden) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getOrdenPK().setIdautorizacion(current.getAutorizacion().getIdautorizacion());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("OrdenUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Orden) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("OrdenDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Orden getOrden(pe.hotelho.hotel.entidades.OrdenPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Orden.class)
    public static class OrdenControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OrdenController controller = (OrdenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ordenController");
            return controller.getOrden(getKey(value));
        }

        pe.hotelho.hotel.entidades.OrdenPK getKey(String value) {
            pe.hotelho.hotel.entidades.OrdenPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new pe.hotelho.hotel.entidades.OrdenPK();
            key.setIdautorizacion(Integer.parseInt(values[0]));
            key.setIdorden(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(pe.hotelho.hotel.entidades.OrdenPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdautorizacion());
            sb.append(SEPARATOR);
            sb.append(value.getIdorden());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Orden) {
                Orden o = (Orden) object;
                return getStringKey(o.getOrdenPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Orden.class.getName());
            }
        }
    }
}
