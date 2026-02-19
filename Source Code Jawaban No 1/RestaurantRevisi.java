public class RestaurantRevisi {
    //attribute class
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    //Constructor
    public RestaurantRevisi() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    //Getter, pakai parameter index [i] karna hanya baca aja isi attribute private
    public String GetNamaMakanan (int i){
        return this.nama_makanan[i];
    }

    public double GetHargaMakanan(int i){
        return this.harga_makanan[i];
    }

    public int GetStok(int i){
        return this.stok[i];
    }

    public static byte GetId(){
        return id;
    }

    //Setter, pakai variabel global [id] karna akan mengupdate attribute private
    public void SetNamaMakanan(String nama){
        this.nama_makanan[id] = nama;
    }

    public void SetHargaMakanan(double harga){
        this.harga_makanan[id] = harga;
    }

    public void SetStok(int stok){
        //validasi stok gaboleh negatif
        if(stok < 0){
            System.out.println("Stok harus lebih dari sama dengan 0");
            this.stok[id] = 0;
        } else{
            this.stok[id] = stok;
        }
   
    }
    
    //static gabisa pake this.
    public static void SetId(byte id){
        RestaurantRevisi.id = id;
    } 

    //print semua menu
    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(i+1+"." +GetNamaMakanan(i) + "[" + GetStok(i) + "]" + "\t Rp." + GetHargaMakanan(i));
            }
        }
    }

    //cekstok
    public boolean isOutOfStock(int id) {
        if (stok[id] == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    //counter menu selanjutnya, pakai static agar di main tinggal panggil aja dari class restaurant
    public static void nextId() {
        id++;
    }

    public void pesanmenu(int nomormenu, int jumlahporsi){

        if(jumlahporsi > GetStok(nomormenu)){
            System.out.println("Pesanan dikembalikan, stoknya tidak mencukupi");
        }
        else{
            this.stok[nomormenu] = GetStok(nomormenu) - jumlahporsi;
            System.out.println("selamat menikmati ");
        }
    }
}

