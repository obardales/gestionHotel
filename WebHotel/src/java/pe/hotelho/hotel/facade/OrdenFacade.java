/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.hotelho.hotel.entidades.Orden;

/**
 *
 * @author obardales
 */
@Stateless
public class OrdenFacade extends AbstractFacade<Orden> {
    @PersistenceContext(unitName = "WebHotelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenFacade() {
        super(Orden.class);
    }
    
}
