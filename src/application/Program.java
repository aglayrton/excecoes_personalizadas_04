package application;

import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    //throws ParseException - ele propaga a exececao, ou seja, o main pode lançar e nao precisa tratar
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Digite o número do quarto");
        int numero = sc.nextInt();
        System.out.println("Digite o Check-in no formato (dd/MM/yyyy)");
        //converto o string para formato de data
        Date checkIn = sdf.parse(sc.next());//vai dar erro, dai ele perde para adicionar uma exececao
        System.out.println("Digite o Check-in no formato (dd/MM/yyyy)");
        Date checkOut = sdf.parse(sc.next());

        //SE DIGITA O CHECKIN POSTERIOR A DE CHECKOUT isso deve parar o programar e dizer que o
        //chekout tem que ser posterior
        if(!checkOut.after(checkIn)){
            System.out.println("Error ao reservar");
        }else{
            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("Reserva: "+reserva);
        }
    }
}
