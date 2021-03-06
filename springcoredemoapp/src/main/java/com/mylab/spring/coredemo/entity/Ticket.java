package com.mylab.spring.coredemo.entity;

public class Ticket implements Entity {

    private Long id;
    private Double price;
    private Integer seat;
    private Event event;

    public Ticket() {}

    public Ticket(Event event, Integer seat) {
        this.event = event;
        this.price = event.getBasePrice();
        this.seat = seat;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != null ? !id.equals(ticket.id) : ticket.id != null) return false;
        if (!event.equals(ticket.getEvent())) return false;
        if (!price.equals(ticket.price)) return false;
        return seat.equals(ticket.seat);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + price.hashCode();
        result = 31 * result + event.hashCode();
        result = 31 * result + seat.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ticket{");
        sb.append("id=").append(id);
        sb.append(", event=").append(event.getName());
        sb.append(", price=").append(price);
        sb.append(", seat=").append(seat);
        sb.append('}');
        return sb.toString();
    }
}
