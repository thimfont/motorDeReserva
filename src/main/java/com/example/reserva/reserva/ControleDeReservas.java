package com.example.reserva.reserva;

import com.example.reserva.hotel.Hotel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ControleDeReservas {
    private static Map<String, Reserva> reservas = new HashMap<>();

    public boolean adiciona(Reserva reserva) {
        if (reservaDisponivel(reserva)) {
            reservas.put(reserva.getId(), reserva);
            return true;
        }
        return false;
    }

    private boolean reservaDisponivel(Reserva reserva) {
        return !reservas.containsValue(reserva);
    }

    public Collection<Hotel> listaOsQuartosDisponiveis(Collection<Hotel> hoteis, Busca busca) {
        // TODO implementar lógica
        return null;
    }

    public void imprimeReservas() {
        System.out.println(reservas.values());
    }
}
