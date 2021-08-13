package pruebas.test.org;


public class Process {

    public static void main (String args[]) throws Exception {
        ContractCreation c = new ContractCreation();
        int contador=0;
            while (contador< 10) {

                c.postKobleClassicCsuiteContract();
               //c.CreateDEOffer();
                //c.postKobleSwitchContract();
                //c.CreateCHOffer();

                //postKobleHouseholdContract();
                //postKobleLiabilityContract();
                //c.postKobleLiabilityv2021Contract();
                contador++;
            }

    }

}
