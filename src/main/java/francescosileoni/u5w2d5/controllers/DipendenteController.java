package francescosileoni.u5w2d5.controllers;

import francescosileoni.u5w2d5.entities.Dipendente;
import francescosileoni.u5w2d5.exception.BadRequestException;
import francescosileoni.u5w2d5.payloads.NewDipendenteResponse;
import francescosileoni.u5w2d5.payloads.PayloadDipendenti;
import francescosileoni.u5w2d5.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> getDipendenti (){
        return this.dipendenteService.getDipendenti();
    }


    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    private NewDipendenteResponse saveEmployee(@RequestBody @Validated PayloadDipendenti body, BindingResult validation){
        if (validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }
        return new NewDipendenteResponse(this.dipendenteService.saveEmployee(body).getId());
    }

    @GetMapping("/{dipendenteId}")
    private Dipendente getDipendentibyID(@PathVariable int dipendenteId){
        return (Dipendente) this.dipendenteService.getDipendenti(dipendenteId);
    }

    @PutMapping("/{dipendenteId}")
    private Dipendente dipendenteUpdate(@PathVariable int dipendenteId, @RequestBody Dipendente body){
        return this.dipendenteService.updateDipendbyId(dipendenteId, body);
    }

    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteDipendete(@PathVariable int dipendenteId){
        this.dipendenteService.deleteDipendById(dipendenteId);
    }


}
