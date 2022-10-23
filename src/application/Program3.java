package application;

import model.entities.Reserva;
import model.entities.Reserva3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program3 {
    //melhorando o programa
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
            Reserva3 reserva = new Reserva3(numero, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println("Entre com a data atualizada");
            System.out.println("Digite o Check-in no formato (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Digite o Check-in no formato (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());

            Date agora = new Date();
            //retorna uma string
            //AJEITAMOS A DELEGAÇÃO
            String error = reserva.atualizarDatas(checkIn, checkOut);
            if(error != null){
                System.out.println("Reservation: " + error);
            }
            else {
                System.out.println("Reservation: " + reserva);
            }
        }
    }
}
