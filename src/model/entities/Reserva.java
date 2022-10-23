package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    //estatico pra nao precisar instancia, basta chamar pela classe
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //formato string, pode colocar somente ano se quiser

    public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }
    //calcular datas
    public long duracao(){
        //calcular em milesegundos - getTime retorna o milesegundos de uma data
        long diff = checkOut.getTime() - checkIn.getTime(); //pego a diferença das datas em milesegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//CONVERTE PARA DIAS - valores
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "numeroQuarto= " + numeroQuarto +
                ", checkIn= " + sdf.format(checkIn) +
                ", checkOut= " + sdf.format(checkOut) +
                ", duração= "+duracao()+
                " noites}";
    }

    public void atualizarDatas(Date checkIn, Date checkOut) {
        Date now = new Date();

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

}