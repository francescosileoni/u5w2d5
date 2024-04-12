package francescosileoni.u5w2d5.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "dispositivi")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Dispositivo {
    @Id
    @GeneratedValue
    private int id;

    private String tipo;

    private String stato;

    @ManyToOne
    private Dipendente dipendente;

    public Dispositivo( String stato, String tipo) {


        this.stato = stato;
        this.tipo = tipo;
    }
}
