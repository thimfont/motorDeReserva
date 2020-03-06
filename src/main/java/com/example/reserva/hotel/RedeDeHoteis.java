package com.example.reserva.hotel;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RedeDeHoteis {
    private static Map<String, Hotel> hoteis = new HashMap<>();

    public void adiciona(Hotel hotel) {
        hoteis.put(hotel.getCod(), hotel);
    }

    public boolean hotelFazParteDaRede(Hotel hotel) {
        return hoteis.containsValue(hotel);
    }

    public void adicionaQuartoParaO(Hotel hotel, Quarto q3) {
        hotel.adiciona(q3);
        hoteis.put(hotel.getCod(), hotel);
    }

    public Collection<Hotel> listaTodosOsHoteis() {
        return Collections.unmodifiableCollection(hoteis.values());
    }
}
