package ar.com.ada.api.billeteravirtual.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Cuenta
 */
@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuentaId;

    private String moneda;

    private BigDecimal saldo = new BigDecimal(0);

    @Column(name = "saldo_disponible")
    private BigDecimal saldoDisponible = new BigDecimal(0);;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>();

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public Billetera getBilletera() {
        return billetera;
    }

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public void agregarPlata(String concepto, BigDecimal importe, String detalle) {
        
        this.agregarPlata(this.billetera.getPersona().getUsuario().getUsuarioId(), this.cuentaId, concepto , importe, detalle);
    }

    public void agregarPlata(int usuarioDe, int cuentaDe, String concepto, BigDecimal importe, String detalle) {
        Movimiento m = new Movimiento();

        m.setCuenta(this);
        m.setTipoOperacion("INGRESO");
        m.setImporte(importe);
        m.setConceptoOperacion(concepto);
        m.setDetalle(detalle);
        m.setFechaMovimiento(new Date());
        m.setDeUsuarioId(usuarioDe);
        m.setaUsuarioId(this.billetera.getPersona().getUsuario().getUsuarioId());
        m.setDeCuentaId(cuentaDe);
        m.setaCuentaId(this.cuentaId);

        this.movimientos.add(m);
    }

    /*public void descontarPlata(int usuarioA, String concepto, BigDecimal importe, String detalle){
        descontarPlata(int usuarioA,  int cuentaA, String concepto, BigDecimal importe, String detalle){

    }*/
    public void descontarPlata(int usuarioA,  int cuentaA, String concepto, BigDecimal importe, String detalle){
        Movimiento m = new Movimiento();

        m.setCuenta(this);
        m.setTipoOperacion("EGRESO");
        m.setImporte(importe.negate());
        m.setConceptoOperacion(concepto);
        m.setFechaMovimiento(new Date());
        m.setDeUsuarioId(this.billetera.getPersona().getUsuario().getUsuarioId());
        m.setaUsuarioId(usuarioA);
        m.setDeCuentaId(this.cuentaId);
        m.setaCuentaId(cuentaA);

    }


}