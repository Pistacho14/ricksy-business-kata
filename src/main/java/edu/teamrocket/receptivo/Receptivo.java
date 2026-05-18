package edu.teamrocket.receptivo;

import java.util.ArrayList;
import java.util.List;

import edu.teamrocket.payment.PaymentMethod;

public class Receptivo {

    private static Receptivo instance = null;

    private List<GuestDispatcher> receptivo = new ArrayList<>();

    private Receptivo() {
    }

    public void registra(GuestDispatcher dispatcher) {
        receptivo.add(dispatcher);
    }

    public void dispatch(PaymentMethod usuario) {
        for (GuestDispatcher receptor : receptivo) {
            receptor.dispatch(usuario);
        }
    }

    public static Receptivo getReceptivo() {
        return instance = instance == null ? new Receptivo() : instance;
    }

}
