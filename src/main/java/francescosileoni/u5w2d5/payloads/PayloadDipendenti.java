package francescosileoni.u5w2d5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record PayloadDipendenti(

    @NotEmpty(message = "Don't forget to add a username")
    @Size(min = 5, max = 30, message = "The username must be between 5 and 30 characters")
    String username,

    @NotEmpty(message = "Don't forget to add your first name")
    @Size(min = 5, max = 30, message = "The first must be between 5 and 30 characters")
    String nome,

    @NotEmpty(message = "Don't forget to add your surname")
    @Size(min = 5, max = 30, message = "The surname must be between 5 and 30 characters")
    String cognome,

    @NotEmpty(message = "Don't forget to add your email")
    @Email(message = "The given email is not valid")
    String email){

}
