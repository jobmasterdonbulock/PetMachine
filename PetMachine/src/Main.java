import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private  final static PetMachine petmachine = new PetMachine();

    public static void main(String[] args) {
        scanner.useDelimiter("\\n");
        var option = -1;

        do{
            System.out.println("===Escolha uma das opções===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 -  Abastecer máquina com água");
            System.out.println("3 -  Abastecer máquina com shampoo");
            System.out.println("4 -  Verificar água da máquina");
            System.out.println("5 -  Verificar shampoo da máquina");
            System.out.println("6 -  Verificar se tem pet no banho");
            System.out.println("7 -  Colocar pet na  máquina");
            System.out.println("8 -  Retirar pet da máquina");
            System.out.println("9 -  Limpar máquina");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch (option){
                case 1 -> petmachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> checkifhasPetinMachine();
                case 7 -> setPetinPetMachine();
                case 8 -> petmachine.removePet();
                case 9 -> petmachine.wash();
                case 0 -> System.exit(0);
                default -> System.out.println("opção invalida");
            }

        }while (true);

    }

    private static void  setShampoo(){
        System.out.println("Tentando colocar shampoo na máquina");
        petmachine.addShampoo();
    }

    private static void  setWater(){
        System.out.println("Tentando colocar água na máquina");
        petmachine.addWater();
    }

    private static void verifyWater() {
        var amount = petmachine.getWater();
        System.out.println("A máquina esta no momento com " + amount + "Litros de água");
    }

    private static void verifyShampoo() {
        var amount = petmachine.getShampoo();
        System.out.println("A máquina esta no momento com " + amount + "Litros de shampoo");
    }

    private static void checkifhasPetinMachine() {
        var hasPet = petmachine.hasPet();
        System.out.println(hasPet ? "Tem pet na máquina " : "Não tem pet na máquina");
    }

    public static void setPetinPetMachine(){
        var name = "";
        while (name == null || name.isEmpty()){
            System.out.println("Informe o nome do pet");
            name = scanner.next();
        }
        var pet = new Pet(name);
        petmachine.setPet(pet);
        System.out.println("O pet " + pet.getName() + " foi colocado na máquina");
    }

}