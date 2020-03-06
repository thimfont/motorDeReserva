package com.example.reserva.hotel;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Hotel {
    private String cod;
    private String nome;
    private CategoriaDoHotel categoria;
    private Set<Quarto> quartos;

    public Hotel(String cod, String nome, CategoriaDoHotel categoria) {
        this.cod = cod;
        this.nome = nome;
        this.categoria = categoria;
        this.quartos = new HashSet<>();

    }

    public void adiciona(Quarto quarto) {
        this.quartos.add(quarto);
    }

    public String getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaDoHotel getCategoria() {
        return categoria;
    }

    public Set<Quarto> getQuartos() {
        return Collections.unmodifiableSet(quartos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(cod, hotel.cod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "quartos=" + quartos +
                '}';
    }
}
