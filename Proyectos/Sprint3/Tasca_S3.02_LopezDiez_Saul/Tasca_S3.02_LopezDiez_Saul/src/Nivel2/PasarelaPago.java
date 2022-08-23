package Nivel2;


import java.util.Optional;

public abstract class PasarelaPago {

    final void executeWith(Callback callback) {
        execute();
        Optional.ofNullable(callback).ifPresent(Callback::call);
    }

    public abstract void execute();
}
