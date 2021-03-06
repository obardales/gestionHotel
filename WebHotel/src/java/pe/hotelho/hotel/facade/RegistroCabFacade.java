/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.hotelho.hotel.entidades.RegistroCab;

/**
 *
 * @author obardales
 */
@Stateless
public class RegistroCabFacade extends AbstractFacade<RegistroCab> {
    @PersistenceContext(unitName = "WebHotelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroCabFacade() {
        super(RegistroCab.class);
    }
    
}
