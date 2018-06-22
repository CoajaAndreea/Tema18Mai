import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Loto {
    static final int MAX=6;

    public static void main(String[] args) {

        int contor=1;

        //generare bilete
        Set<Integer> biletAgentie=generate6Numbers();
        Set<Integer> biletulMeu=generate6Numbers();

        //afisare bilete
        printTicket(biletAgentie);
        printTicket(biletulMeu);

        //cate numere sunt egale
        int egale=compareTickets(biletAgentie, biletulMeu);

        while(egale<6) {
            biletulMeu=generate6Numbers();
            contor++;
            System.out.println(contor);
            egale=compareTickets(biletAgentie, biletulMeu);
        }

        System.out.println("Biletul castigator este: ");
        printTicket(biletAgentie);
        System.out.println("Biletul tau este: ");
        printTicket(biletulMeu);
    }

    public static Set generate6Numbers() {
        Set<Integer> winnerNumbers= new LinkedHashSet<Integer>();
//        int[] winnerNumbers=new int[6];
        int i=0;

        while(i<MAX) {
            winnerNumbers.add(new Random().nextInt(49)+1);
            i++;
        }

        return winnerNumbers;
    }

    public static int compareTickets (Set<Integer> agencyTicket, Set<Integer> myTicket) {
        int ok=0;
        for (Integer x : agencyTicket)
            for (Integer y : myTicket)
                if (x.equals(y))
                    ok++;
        return ok;
    }

    public static void printTicket(Set<Integer> ticket) {
            System.out.print(ticket);

        System.out.println();
    }
}
