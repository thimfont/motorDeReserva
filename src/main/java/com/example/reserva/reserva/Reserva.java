package com.example.reserva.reserva;

import com.example.reserva.hotel.Hotel;
import com.example.reserva.hotel.Quarto;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva {
    private String id;
    private Hotel hotel;
    private Quarto quarto;
    private LocalDate checkin;
    private LocalDate checkout;

    public Reserva(Hotel hotel, Quarto quarto, LocalDate checkin, LocalDate checkout) {
        this.hotel = hotel;
        this.quarto = quarto;
        this.checkin = checkin;
        this.checkout = checkout;
        this.id = hotel.getCod() + quarto.getId();
    }

    public String getId() {
        return id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id) &&
                Objects.equals(checkin, reserva.checkin) &&
                Objects.equals(checkout, reserva.checkout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkin, checkout);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "checkin=" + checkin +
                ", checkout=" + checkout +
                '}';
    }
}