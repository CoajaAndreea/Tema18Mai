import java.util.Random;

public class Loto {
    static final int MAX=6;

    public static void main(String[] args) {

        int contor=1;

        //generare bilete
        int[] biletAgentie=generate6Numbers();
        int[] biletulMeu=generate6Numbers();

        //afisare bilete
        printTicket(biletAgentie);
        printTicket(biletulMeu);

        //cate numere sunt egale
        int egale=compareTickets(biletAgentie, biletulMeu);

        while(egale<4) {
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

    public static int[] generate6Numbers() {
        int[] winnerNumbers=new int[6];
        int i=0;

        while(i<MAX) {
            winnerNumbers[i]=new Random().nextInt(49)+1;
            for (int j=0;j<MAX;j++) {
                while (winnerNumbers[i]==winnerNumbers[j] && i!=j)
                    winnerNumbers[i]=new Random().nextInt(49)+1;
            }
            i++;
        }

        return winnerNumbers;
    }

    public static int compareTickets (int[] agencyTicket, int[] myTicket) {
        int ok=0;
        for (int i=0;i<MAX;i++)
            for (int j=0;j<MAX;j++)
                if (myTicket[i]==agencyTicket[j])
                    ok++;
        return ok;
    }

    public static void printTicket(int[] ticket) {
        for (int i=0;i<MAX;i++) {
            System.out.print(ticket[i]+" ");
        }
        System.out.println();
    }
}
