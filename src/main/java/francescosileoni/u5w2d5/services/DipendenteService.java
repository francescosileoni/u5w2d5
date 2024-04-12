package francescosileoni.u5w2d5.services;

import francescosileoni.u5w2d5.entities.Dipendente;
import francescosileoni.u5w2d5.exception.NotFoundException;
import francescosileoni.u5w2d5.payloads.PayloadDipendenti;
import francescosileoni.u5w2d5.repositories.DipendenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class DipendenteService {


        @Autowired
        DipendenteDAO dipendenteDAO;

        public List<Dipendente> getDipendenti(){
            return this.dipendenteDAO.findAll();
        }

        public Dipendente saveEmployee(PayloadDipendenti body){
            Dipendente newDipendente = new Dipendente(body.username(),body.nome(), body.cognome(), body.email(), "https://ui-avatars.com/api/?name="+ body.nome() + "-" + body.cognome(), new ArrayList<>());
            return this.dipendenteDAO.save(newDipendente);
        }

        public Dipendente findDipendentiId(int id){
            return dipendenteDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        }

        public Dipendente updateDipendbyId (int id, Dipendente updatedBody){
            Optional<Dipendente> optionalEmployee = dipendenteDAO.findById(id);

            if (optionalEmployee.isPresent()){
                Dipendente found = optionalEmployee.get();
                found.setUsername(updatedBody.getUsername());
                found.setNome(updatedBody.getNome());
                found.setCognome(updatedBody.getCognome());
                found.setEmail(updatedBody.getEmail());

                return this.dipendenteDAO.save(found);
            }else {
                throw new NotFoundException(id);
            }
        }

        public void deleteDipendById (int id){
            Optional<Dipendente> optionalEmployee = dipendenteDAO.findById(id);

            if (optionalEmployee.isPresent()){
                Dipendente found = optionalEmployee.get();
                this.dipendenteDAO.delete(found);
            }else{
                throw new NotFoundException(id);
            }
        }
    }


