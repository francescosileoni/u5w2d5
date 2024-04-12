package francescosileoni.u5w2d5.controllers;


import francescosileoni.u5w2d5.entities.Dispositivo;
import francescosileoni.u5w2d5.payloads.PayloadDispositivi;
import francescosileoni.u5w2d5.services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

    @Autowired
    DispositivoService dispositivoService;

    @GetMapping
    private List<Dispositivo> getDispositvi() {
        return this.dispositivoService.getDispositivi();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Dispositivo saveDevice(@RequestBody PayloadDispositivi body) {
        return dispositivoService.saveDispositivo(body);
    }

    @GetMapping("/{dispositivo_Id}")
    public Dispositivo findDispositivoById(@PathVariable int dispositivo_Id) {
        return this.dispositivoService.findDispositivoById(dispositivo_Id);
    }

    @PutMapping("/{dispositivo_Id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Dispositivo updateDispositivoByID(@PathVariable int  dispositivo_Id, @RequestBody Dispositivo body) {
        return this.dispositivoService.UpdateDispById(dispositivo_Id, body);
    }

    @DeleteMapping("/{deviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void DispDelete(@PathVariable int deviceId){
        this.dispositivoService.DeleteDispByID(deviceId);
    }



}
