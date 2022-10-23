package application;

import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Digite o número do quarto");
        int numero = sc.nextInt();
        System.out.println("Digite o Check-in no formato (dd/MM/yyyy)");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Digite o Check-in no formato (dd/MM/yyyy)");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error ao reservar");
        } else {
            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            //ATUALIZAR
            System.out.println("Entre com a data atualizada");
            System.out.println("Digite o Check-in no formato (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Digite o Check-in no formato (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());

            Date agora = new Date();
            if (checkIn.before(agora) || checkOut.before(agora)) {
                System.out.println("A reserva deve ter datas futuras");
            } else if (!checkOut.after(checkIn)) {//senao for posterior
                System.out.println("Check-out date must be after check-in date");
            } else {
                reserva.atualizarDatas(checkIn, checkOut);
                System.out.println("Reservation: " + reserva);
            }
        }
    }
}
