/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.hotelho.hotel.entidades.HabitacionEstado;

/**
 *
 * @author obardales
 */
@Stateless
public class HabitacionEstadoFacade extends AbstractFacade<HabitacionEstado> {
    @PersistenceContext(unitName = "WebHotelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HabitacionEstadoFacade() {
        super(HabitacionEstado.class);
    }
    
}
