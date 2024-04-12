package francescosileoni.u5w2d5.services;

import francescosileoni.u5w2d5.entities.Dispositivo;
import francescosileoni.u5w2d5.exception.NotFoundException;
import francescosileoni.u5w2d5.payloads.PayloadDispositivi;
import francescosileoni.u5w2d5.repositories.DipendenteDAO;
import francescosileoni.u5w2d5.repositories.DispositivoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    DispositivoDAO dispositivoDAO;
    @Autowired
    DipendenteDAO dipendenteDAO;

    public List<Dispositivo> getDispositivi(){
        return this.dispositivoDAO.findAll();
    }

    public Dispositivo saveDispositivo(PayloadDispositivi body){
       Dispositivo newDispositivo = new Dispositivo(body.stato(), body.tipo());
        return this.dispositivoDAO.save(newDispositivo);
    }

    public Dispositivo findDispositivoById(int id){
        return this.dispositivoDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }


    public void DeleteDispByID(int id){
        Optional<Dispositivo> optionalDevice = dispositivoDAO.findById(id);
        if (optionalDevice.isPresent()){
          Dispositivo found = optionalDevice.get();
            this.dispositivoDAO.delete(found);
        }else {
            throw new NotFoundException(id);
        }

    }

    public Dispositivo UpdateDispById(int id, Dispositivo body){
        Optional<Dispositivo> optionalDevice = dispositivoDAO.findById(id);

        if (optionalDevice.isPresent()){
            Dispositivo found = optionalDevice.get();
            found.setDipendente(optionalDevice.get().getDipendente());
            found.setStato(optionalDevice.get().getStato());
            return this.dispositivoDAO.save(found);
        }else {
            throw new NotFoundException(id);
        }

    }

}
