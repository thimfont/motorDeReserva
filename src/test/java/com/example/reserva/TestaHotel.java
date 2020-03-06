package com.example.reserva;

import com.example.reserva.hotel.*;
import com.example.reserva.reserva.Busca;
import com.example.reserva.reserva.ControleDeReservas;
import com.example.reserva.reserva.Reserva;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

public class TestaHotel {
    public static void main(String[] args) {
        Quarto q1 = new Quarto("1", "Bom Sonhos", TipoDeQuarto.SOLTERIO);
        Quarto q2 = new Quarto("2", "Good by", TipoDeQuarto.CASAL);
        Quarto q3 = new Quarto("3", "Good", TipoDeQuarto.CASAL);
        Hotel hotel = new Hotel("10", "Ibirapuera", CategoriaDoHotel.BASIC);

        RedeDeHoteis rede = new RedeDeHoteis();
        rede.adiciona(hotel);
        rede.adicionaQuartoParaO(hotel, q1);
        rede.adicionaQuartoParaO(hotel, q2);
        rede.adicionaQuartoParaO(hotel, q3);

        rede.hotelFazParteDaRede(hotel);
        Collection<Hotel> hoteis = rede.listaTodosOsHoteis();

        LocalDate checkin = LocalDate.now();
        LocalDate checkout = LocalDate.now().plusDays(1);
        System.out.println("Reserva com checkin: " + checkin);
        System.out.println("Reserva com checkout: " + checkout);
        Reserva r1 = new Reserva(hotel, q1, checkin, checkout);
        Reserva r2 = new Reserva(hotel, q1, checkin, checkout);

        ControleDeReservas reservasDaRede = new ControleDeReservas();
        reservasDaRede.adiciona(r1);
        reservasDaRede.adiciona(r2); // nao efetua a reserva
        reservasDaRede.imprimeReservas();

        Busca parametros = new Busca();
        parametros.setCodHotel(hotel.getCod());
        parametros.setCheckin(checkin);
        parametros.setCheckout(checkout);
        // acrescimo de dias
//        parametros.setCheckin(checkin.plusDays(3));
//        parametros.setCheckout(checkout.plusDays(2));

        System.out.println("");
        System.out.println("Busca com checkin: " + parametros.getCheckin());
        System.out.println("Busca com checkout: " + parametros.getCheckout());
        Collection<Hotel> hoteisFiltrados = reservasDaRede.listaOsQuartosDisponiveis(hoteis, parametros);
        System.out.println(hoteisFiltrados);

    }
}
