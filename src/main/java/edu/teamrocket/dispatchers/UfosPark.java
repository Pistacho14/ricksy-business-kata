package edu.teamrocket.dispatchers;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import edu.teamrocket.payment.PaymentMethod;
import edu.teamrocket.receptivo.GuestDispatcher;

public class UfosPark implements GuestDispatcher {

    private Map<String, String> flota = new HashMap<>();
    private static final double FEE = 500;

    public void add(String ovni) {
        flota.putIfAbsent(ovni, null);
    }

    @Override
    public void dispatch(PaymentMethod usuario) {
        if (!flota.containsValue(usuario.number())) {
            for (var entry : flota.entrySet()) {
                if (Objects.equals(entry.getValue(), null) && usuario.pay(FEE)) {
                    entry.setValue(usuario.number());
                    break;
                }
            }
        }
    }

    public String getUfoOf(String numero) {
        for (var ovni : flota.entrySet()) {
            if (Objects.equals(ovni.getValue(), numero)) {
                return ovni.getKey();
            }
        }
        return null;
    }

    public boolean containsCard(String numero) {
        return flota.containsValue(numero);
    }

    public Collection<String> cardNumbers() {
        return flota.values();
    }

    @Override
    public String toString() {
        String[] ufosID = this.flota.keySet().toArray(new String[flota.size()]);
        Arrays.sort(ufosID);
        return List.of(ufosID).toString();
    }
}
