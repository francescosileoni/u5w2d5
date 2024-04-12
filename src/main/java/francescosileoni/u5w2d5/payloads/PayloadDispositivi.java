package francescosileoni.u5w2d5.payloads;

import jakarta.validation.constraints.NotEmpty;

public record PayloadDispositivi(

        @NotEmpty(message = "The device must have a status")
        String stato,

        @NotEmpty(message = "You must specify what type of device it is")
        String tipo) {
}

