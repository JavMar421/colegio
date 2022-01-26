import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger orden = new AtomicInteger(1);

    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            Hilos hilo = new Hilos(0);
            hilo.setName("Alumno "+ i );
            hilo.start();

           /* try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        Hilos Profesor = new Hilos(0);



    }
}

class Hilos extends Thread {
    int orden;
    public Hilos(int orden) {
        this.orden = orden;
    }


    @Override
    public void run() {
        Clase.Llegar(this);
    }





}
class Clase{
    public static void Llegar(Hilos hilo){
        try {
            Thread.sleep((new Random().nextInt(5) * 1000));
            Clase.Ordenar(hilo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }


        public static void Ordenar(Hilos hilo){
        int num = Main.orden.getAndIncrement();
        if (num <= 30){
        hilo.orden=num;
        System.out.println("El "+ hilo.getName()+" ha llegado el "+hilo.orden+"º ");
            if (num==15){
                System.out.println("La Clase ha empezado");}

            if (hilo.orden<=5){
                System.out.println("El "+ hilo.getName()+ " con posición "+hilo.orden+" tiene un positivo");}

           else if (hilo.orden>=25){
                System.out.println("El "+ hilo.getName()+ " con posición "+hilo.orden+" tiene un negativo");
            }
        }

    }
        public static void Orden(Hilos hilo){
            }
        }


            /*
                if (hilo.orden<5){
                    System.out.println("El "+ hilo.getName()+" ha recibido un Positivo");
                }
                else if(hilo.orden>=25){
                    System.out.println("El "+ hilo.getName()+" ha recibido un Negativo");
            }*/




