package francescosileoni.u5w2d5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "dipendenti")
@Getter @Setter @NoArgsConstructor @ToString
public class Dipendente {
    @Id
    @GeneratedValue
    private int id;

    private String username;

    private String nome;

    private String cognome;

    private String email;

    private String immagineUrl;

    @OneToMany(mappedBy = "dipendente")
    private List<Dispositivo> dispositivi = new ArrayList<>();

    public Dipendente(String cognome, List<Dispositivo> dispositivi, String email, int id, String immagineUrl, String nome, String username) {
        this.cognome = cognome;
        this.dispositivi = dispositivi;
        this.email = email;
        this.id = id;
        this.immagineUrl = immagineUrl;
        this.nome = nome;
        this.username = username;
    }
}

