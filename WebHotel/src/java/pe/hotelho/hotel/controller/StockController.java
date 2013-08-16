package pe.hotelho.hotel.controller;

import pe.hotelho.hotel.entidades.Stock;
import pe.hotelho.hotel.controller.util.JsfUtil;
import pe.hotelho.hotel.controller.util.PaginationHelper;
import pe.hotelho.hotel.facade.StockFacade;

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

@Named("stockController")
@SessionScoped
public class StockController implements Serializable {

    private Stock current;
    private DataModel items = null;
    @EJB
    private pe.hotelho.hotel.facade.StockFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public StockController() {
    }

    public Stock getSelected() {
        if (current == null) {
            current = new Stock();
            current.setStockPK(new pe.hotelho.hotel.entidades.StockPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private StockFacade getFacade() {
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
        current = (Stock) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Stock();
        current.setStockPK(new pe.hotelho.hotel.entidades.StockPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getStockPK().setIdservicios(current.getServicios().getIdservicios());
            current.getStockPK().setIdalmacen(current.getAlmacen().getIdalmacen());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StockCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Stock) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getStockPK().setIdservicios(current.getServicios().getIdservicios());
            current.getStockPK().setIdalmacen(current.getAlmacen().getIdalmacen());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StockUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Stock) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StockDeleted"));
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

    public Stock getStock(pe.hotelho.hotel.entidades.StockPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Stock.class)
    public static class StockControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            StockController controller = (StockController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "stockController");
            return controller.getStock(getKey(value));
        }

        pe.hotelho.hotel.entidades.StockPK getKey(String value) {
            pe.hotelho.hotel.entidades.StockPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new pe.hotelho.hotel.entidades.StockPK();
            key.setIdservicios(Integer.parseInt(values[0]));
            key.setIdalmacen(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(pe.hotelho.hotel.entidades.StockPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdservicios());
            sb.append(SEPARATOR);
            sb.append(value.getIdalmacen());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Stock) {
                Stock o = (Stock) object;
                return getStringKey(o.getStockPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Stock.class.getName());
            }
        }
    }
}
