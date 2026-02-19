import java.util.Scanner;

public class RestaurantMainRevisi {
    public static int checkinputmenu(Scanner input){
        int pilihanmenu;
        do{
            System.out.println("Pilih menu ke-berapa (pilih dengan angka)?");
            pilihanmenu = input.nextInt();
                
            if(pilihanmenu <= 0 || pilihanmenu > RestaurantRevisi.GetId()){
                System.out.println(
                    "Menu Tidak ada, silahkan pilih nomor menu lain yang tersedia pada daftar\n"
                );
            }
        }while (pilihanmenu <= 0 || pilihanmenu > RestaurantRevisi.GetId());

        return pilihanmenu;
    }

    public static int checkinputporsi(Scanner input){
        int pilihanporsi;
        do{
            System.out.println("Pilih mau berapa porsi (pilih dengan angka)?");
            pilihanporsi = input.nextInt();
                
            if(pilihanporsi <= 0){
                System.out.println(
                    "Porsi minimal pemesanan itu 1, silahkan input kembali porsi\n"
                );
            }
        }while (pilihanporsi <= 0);

        return pilihanporsi;
    }

    public static void main(String[] args) {
        RestaurantRevisi menu = new RestaurantRevisi();
        Scanner inputuser = new Scanner(System.in);
        int menudipilih, porsidipilih;

        //set menu makanan
        menu.SetNamaMakanan("Pizza");
        menu.SetHargaMakanan(250000);
        menu.SetStok(20);
        RestaurantRevisi.nextId();

        menu.SetNamaMakanan("Spaghetti");
        menu.SetHargaMakanan(80000);
        menu.SetStok(20);
        RestaurantRevisi.nextId();

        menu.SetNamaMakanan("Tendeloin");
        menu.SetHargaMakanan(60000);
        menu.SetStok(30);
        RestaurantRevisi.nextId();

        menu.SetNamaMakanan("Chicken");
        menu.SetHargaMakanan(45000);
        menu.SetStok(30);
        RestaurantRevisi.nextId();
        
        //Pemesanan
        System.out.println("\nKamu mau makan apa hari ini?\ndetail menu, stok dan harganya ada di bawah ini:");
        menu.tampilMenuMakanan();
        
        menudipilih = checkinputmenu(inputuser);
        porsidipilih = checkinputporsi(inputuser);

        menu.pesanmenu((menudipilih-1), porsidipilih);
        System.out.println("\nSisa Stok Restoran Saat Ini:");
        menu.tampilMenuMakanan();
    }
}