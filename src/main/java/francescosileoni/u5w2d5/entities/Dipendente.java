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

    public Dipendente (String cognome, String email,  String immagineUrl, String nome, String username) {
        this.cognome = cognome;
        this.email = email;
        this.immagineUrl = immagineUrl;
        this.nome = nome;
        this.username = username;
    }

    public <E> Dipendente(String username, String nome, String cognome, String email, String s, ArrayList<E> es) {
    }
}

